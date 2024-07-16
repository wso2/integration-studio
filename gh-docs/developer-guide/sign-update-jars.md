# How to Sign Integration Studio updates with WSO2 cert

This guide provides step-by-step instructions for signing Integration Studio update artifacts.

## Steps

### 1. Log in to the Windows Signing Server
- Use Remote Desktop to access the Windows signing server. ( Obtain credentials from digi-ops team )

### 2. Download Update Files
- Download the update `.zip` files from Jenkins to `C:\IntegrationStudio`.

### 3. Extract Update Files
- Extract each update `.zip` file into its respective folder.

### 4. Sign JAR Files
- Navigate to each update folder and sign the JAR files using the following command:
  ```sh
  set PATH=%path%;C:\\Program Files\\DigiCert\\DigiCert Keylocker Tools
  smctl sign --keypair-alias=key_578952861 --certificate "C:\Program Files\DigiCert\DigiCert Keylocker Tools\cert_578952861.crt" --config-file C:\IntegrationStudio\pkcs11properties.cfg --input .
  ```

### 5. Extract and Update Artifact XML
- Extract the `artifact.xml.xz` file inside each update.
- Update the hash values of the new JAR files in `artifact.xml` using the following script.
- Update necessory parameters.

  ```python
  import hashlib
  import os
  import xml.etree.ElementTree as ET

  def calculate_hash(file_path, hash_type):
      hash_func = hashlib.new(hash_type)
      with open(file_path, "rb") as f:
          for byte_block in iter(lambda: f.read(4096), b""):
              hash_func.update(byte_block)
      return hash_func.hexdigest()

  def get_jar_files(plugins_path, features_path):
      jar_files = {}
      jar_files.update({file: os.path.join(plugins_path, file) for file in os.listdir(plugins_path) if file.endswith('.jar')})
      jar_files.update({file: os.path.join(features_path, file) for file in os.listdir(features_path) if file.endswith('.jar')})
      return jar_files

  def update_xml_with_hashes(xml_path, jar_files):
      tree = ET.parse(xml_path)
      root = tree.getroot()
      
      for artifact in root.findall(".//artifact"):
          jar_id = artifact.get('id') 
          jar_version = artifact.get('version')
          jar_file_name = f"{jar_id}_{jar_version}.jar"
          
          if jar_file_name in jar_files:
              file_path = jar_files[jar_file_name]
              sha256_hash = calculate_hash(file_path, 'sha256')
              md5_hash = calculate_hash(file_path, 'md5')
              
              for prop in artifact.findall('properties/property'):
                  if prop.get('name') == 'download.checksum.md5':
                      prop.set('value', md5_hash)
                  if prop.get('name') == 'download.md5':
                      prop.set('value', md5_hash)
                  if prop.get('name') == 'download.checksum.sha-256':
                      prop.set('value', sha256_hash)
      
      tree.write(xml_path, encoding='UTF-8', xml_declaration=True)

  def main(plugins_path, features_path, xml_path):
      jar_files = get_jar_files(plugins_path, features_path)
      update_xml_with_hashes(xml_path, jar_files)

  if __name__ == "__main__":
      plugins_path = "<base_path>/wso2-integrationstudio-server-p2-8.2.0-SNAPSHOT/plugins"
      features_path = "<base_path>/wso2-integrationstudio-server-p2-8.2.0-SNAPSHOT/features"
      xml_path = "<base_path>/wso2-integrationstudio-server-p2-8.2.0-SNAPSHOT/artifacts.xml"
      main(plugins_path, features_path, xml_path)
  ```

### 6. Repack the Artifact XML
- Use 7zip (already installed) to repack `artifact.xml` as `artifact.xml.xz`.

### 7. Rezip the Updates
- Rezip the updates. This step must be done on a Windows machine to ensure Integration Studio recognizes the update.

### 8. Test Signed Updates
- Test the signed updates by locally updating Integration Studio.
  - Ensure you untick `Contact all update sites during install to find required software` when installing updates.

### 9. Host the Signed Updates
- Host the signed updates by contacting Integration Studio team lead.

By following these steps, you can successfully sign update artifacts for Integration Studio.