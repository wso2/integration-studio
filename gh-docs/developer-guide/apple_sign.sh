#!/bin/bash

# Path to your .app application
APP_PATH="IntegrationStudio.app"

# Signing identity (replace with your certificate name)
SIGNING_IDENTITY="Developer ID Application: WSO2, Inc. (XXXXXXXXXX)"

# Function to recursively sign all files in a directory
sign_directory() {
  dir_path="$1"
    files="$(find "$dir_path")"
    echo "$files" | while read file; do
      codesign --force --verbose  --timestamp --sign "$SIGNING_IDENTITY" "$file"
    done
}

# Sign all files in the Contents directory
echo "Signing all files in APP_PATH directory..."
sign_directory "$APP_PATH"

echo "Signing process completed."
