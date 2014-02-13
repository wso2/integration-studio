DELIMITER // 
CREATE procedure getCustomer(NID varchar(200),Name varchar(200), OUT Flag INTEGER, OUT CID VARCHAR(200))  
BEGIN 
DECLARE id varchar(200); 
SET Flag = 0;
SET id = CONCAT(NID, '_' ,  Name); 
SELECT 1 INTO Flag FROM Customer WHERE customerID = id;
IF Flag = 1 THEN  
SET CID = id; 
ELSE
INSERT INTO Customer(NID, Name, customerID) VALUES(NID, Name, id); 
SET CID = id; 
END IF; 
END//
