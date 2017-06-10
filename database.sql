/*
SQLyog Community v12.2.1 (64 bit)
MySQL - 5.5.48 : Database - avs_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`avs_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `avs_db`;

/*Table structure for table `addnewvehicle` */

DROP TABLE IF EXISTS `addnewvehicle`;

CREATE TABLE `addnewvehicle` (
  `Vehicleno` varchar(35) NOT NULL,
  `Regno` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Contactno` varchar(12) DEFAULT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `Requirement` varchar(25) DEFAULT NULL,
  `Location` varchar(45) NOT NULL,
  `kilometers` varchar(45) NOT NULL,
  `Year` varchar(45) NOT NULL,
  `Model` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `DueDate` date DEFAULT NULL,
  PRIMARY KEY (`Vehicleno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `addnewvehicle` */

insert  into `addnewvehicle`(`Vehicleno`,`Regno`,`Name`,`Contactno`,`Category`,`Requirement`,`Location`,`kilometers`,`Year`,`Model`,`Date`,`DueDate`) values 
('UP12S3491','2765756','AMAN','9958404785','Break down','RADIATER  REPLACEMENT','MORADABAD','853','2017','24786','2017-04-08','2017-02-08'),
('UP16A5722','5445454','TANMEY','9968077308','SERVICING','ENGINE OIL REPLACEMENT','DELHI','464','2017','11213','2017-03-04','2017-02-04'),
('UP18A3467','1487956','SHIVAM','8858663548','Mechanical job','BREAK PARTS,POWERSTEERING','GHAZIABAD','789','2017','12485','2017-04-08','2017-02-08'),
('UP22F5322','1789657','PUNEET','8802873799','Denting painting','GLOSSY  RED PAINT','KANPUR','659','2017','12358','2017-04-08','2017-02-08'),
('UP23F4547','1401833','SHIV','9875624483','BREAKDOWN','HEADLIGHT BULB,','LUCKNOW','795','2017','14586','2017-04-04','2017-04-04'),
('UP32B8723','2761859','SUMIT','9582355408','MECHANICAL JOB','BREAK SHOL','LUCKNOW','785','2017','11278','2017-03-04','2017-02-04'),
('UP33Q5800','1483574','SHASHWAT','7532025386','DENTING PAINTING','BLACK MATT FINISH','RAEBARELI','659','2017','14785','2017-04-04','2017-03-04'),
('UP42W5722','1484856','AMIT','9453248978','Servicing','AIR FILTER,DIESEL FILTER','NOIDA','1085','2017','14857','2017-04-08','2017-02-08');

/*Table structure for table `billinfo` */

DROP TABLE IF EXISTS `billinfo`;

CREATE TABLE `billinfo` (
  `Bill_no` int(11) DEFAULT NULL,
  `Cust_no` int(11) DEFAULT NULL,
  `Cust_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Po_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Po_date` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Cst_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Tin_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Flddate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Sub_total` int(11) DEFAULT NULL,
  `Tax_per` int(11) DEFAULT NULL,
  `Tax` int(11) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `billinfo` */

insert  into `billinfo`(`Bill_no`,`Cust_no`,`Cust_name`,`Po_no`,`Po_date`,`Cst_no`,`Tin_no`,`Flddate`,`Sub_total`,`Tax_per`,`Tax`,`Total`) values 
(1,1,'alok','2','2/2/33','alok@gmail.com','H7BHGDF7','25/2/12',78224,2,1564,79788),
(2,1,'gdfg','2','1/2/2110','alok@gmail.com','H7BHGDF7','25/2/12',315192,3,9455,324647),
(3,1,'fgdg','1','12/2/330','alok@gmail.com','H7BHGDF7','25/2/12',40000,2,800,40800),
(4,2,'dfggd','11','2/2/333','2345','HJDFEG78','25/2/12',880,4,35,915),
(5,2,'gdgfsdf','11','2/2/33','9898993545','2345','25/2/12',80000,3,2400,82400),
(6,1,'gsgfsfsf','12','211214','alok@gmail.com','H7BHGDF7','25/2/12',4816,2,96,4912),
(7,1,'sgfds','11','11','alok@gmail.com','H7BHGDF7','25/2/12',35600,2,712,36312),
(8,3,'fsdfs','123456','12345','9798797987','stpindust@gmail.com','9/3/12',880,2,17,897),
(9,1,'fsdfsdfs','12345','9-03-12','alok@gmail.com','H7BHGDF7','9/3/12',15600,2,312,15912),
(10,3,'sdfffsfs','234','32213','9798797987','stpindust@gmail.com','9/3/12',20000,2,400,20400),
(11,2,'ersff','','','DNH/09/TIN/098796','9898993545','9/3/12',40440,4,1617,42057),
(12,2,'fsdfsfsdfs','21233','3323','DNH/09/TIN/098796','9898993545','25/4/12',668584,1,6685,675269),
(13,3,'billto','3213','2343','9798797987','stpindust@gmail.com','25/4/12',1320,3,39,1359),
(14,1,'alok industry','3355','6546','alok@gmail.com','H7BHGDF7','25/4/12',630384,5,31519,661903),
(15,2,'alok','','','DNH/09/TIN/098796','9898993545','6/5/17',115004,12,13800,128804),
(16,2,'alok','22','12-12-2017','DNH/09/TIN/098796','9898993545','6/5/17',115804,12,13896,129700),
(17,5,'Famy Care Ltd.','456','12-12-2017','THSTRGTH','DNH/09/TIN/098431','6/5/17',1500,12,180,1680),
(18,11,'Rajesh','2','12-12-2017','12345','4567','6/5/17',1000,12,120,1120);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `Vehicleno` varchar(40) DEFAULT NULL,
  `Cartype` varchar(45) DEFAULT NULL,
  `Worktype` varchar(45) DEFAULT NULL,
  `Item` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`Vehicleno`,`Cartype`,`Worktype`,`Item`) values 
('UPSE6282','Maruti','Servicing','Engine Oil,Oil Filter,'),
('2458702','Tata','Extra','Washing,Dry cleaning,'),
('','Maruti','Denting Painting','Rubber Polishing,Anti rust coating,'),
('fbb 121','Hyundai','Break down',''),
('','Maruti','Mechanical job','Clutch,Suspension,Shocker,Engine over all, Breaks,'),
('','Select','Extra','Washing,Dry cleaning,'),
('4461616','Maruti','Servicing','Gear oil,Break shol,'),
('DL4s62824','Hyundai','Mechanical job','Gear oil,Break shol,Clutch,'),
('A23456789','123','Mechanical job','engine'),
('33333333','e5','Servicing','Engine Oil,Gear oil,'),
('B34567893','s3','Servicing','Engine Oil,Oil Filter,Air Filter,'),
('UP32Q52470','148753','Denting Painting','QBSBDB D'),
('UP32Q5879','12789','Mechanical job','ALL TO BE REPLACED');

/*Table structure for table `customer_master` */

DROP TABLE IF EXISTS `customer_master`;

CREATE TABLE `customer_master` (
  `Customer_no` int(11) DEFAULT NULL,
  `Customer_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Customer_add1` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_add2` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_add3` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_telephone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_Email_ID` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_cstno` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_tinno` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Customer_stexno` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer_master` */

insert  into `customer_master`(`Customer_no`,`Customer_name`,`Customer_add1`,`Customer_add2`,`Customer_add3`,`Customer_telephone`,`Customer_Email_ID`,`Customer_cstno`,`Customer_tinno`,`Customer_stexno`) values 
(1,'alok industry','rakholi','silvassffdsfdsgfgfdgf','DN&H','DNH/07/TIN/098376','9746736689','alok@gmail.com','H7BHGDF7','HIDN7BJH00GT'),
(2,'alok','Masam','silvassa','DN&H','2345','HJDFEG78','DNH/09/TIN/098796','9898993545','HFYIAUYFDIUY'),
(3,'Sumita Texspin Pvt.Ltd','vapi','silvassa','DN&H','DNH/09/TIN/098874','9798797987','stpindust@gmail.com','THYTHYTR','SGFGSFGGGT'),
(4,'Precisions Fastners Ltd','dungra','s','DN&H','HSHTHTHT','DNH/09/TIN/091234','9876878686','pflimited@gmail.com','THYTRHGGHTH'),
(5,'Famy Care Ltd.','Lawacha','silvassa','DN&H','9758758765','fccare@yahoo.com','THSTRGTH','DNH/09/TIN/098431','G54G67657GTY'),
(6,'Famy Care Ltd.','Amil','silvassa','DN&H','9263526757','nilkamalltd@gmail.com','YEWTYTR','DNH/09/TIN/098454','HTRGYGY6YG'),
(7,'Transpek Silox Industry Ltd.','Khan','silvassa','DN&H','DNH/09/TIN/098443','9162817887','tsi2001@yahoo.com','HGFHGFH','BFGH6E6GGF'),
(8,'Valson Industries Ltd.','khanvel','silvassa','DN&H','02938281527','viltd2011@gmail.com','GTHSHTHH','DNH/09/TIN/098544','DFBHDTHB656'),
(9,'Raj Petro & Specialities Pvt.Ltd.','Amli','silvassa','DN&H','02608766877','rpslimited@yahoo.com','TRYTRYRT','DNH/09/TIN/098657','DFBHYTU666H'),
(10,'hhhhhh','silvassa','dadra','DN&H','9898993545','qwerty@gmail.com','YTGGJHDKF','DNH/09/TIN/009857','HHG577JJBHG'),
(11,'Rajesh','new Delhi','delhi','delhi','9015588303','rkproject24@gmail.com','12345','4567','4567');

/*Table structure for table `dummy` */

DROP TABLE IF EXISTS `dummy`;

CREATE TABLE `dummy` (
  `Bill_No` int(11) DEFAULT NULL,
  `Item_No` int(11) DEFAULT NULL,
  `Item_Name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Make` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Srno` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Unit_Price` decimal(18,2) DEFAULT NULL,
  `Unit_Quantity` decimal(18,2) DEFAULT NULL,
  `Total` decimal(18,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dummy` */

insert  into `dummy`(`Bill_No`,`Item_No`,`Item_Name`,`Item_Make`,`Item_Srno`,`Unit_Price`,`Unit_Quantity`,`Total`) values 
(19,1,'abc','1 year','','500.00','2.00','1000.00');

/*Table structure for table `item_master` */

DROP TABLE IF EXISTS `item_master`;

CREATE TABLE `item_master` (
  `Item_no` int(11) DEFAULT NULL,
  `Item_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Make` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Rate` int(11) DEFAULT NULL,
  `Item_Ratio` int(11) DEFAULT NULL,
  `Item_Unit` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_master` */

insert  into `item_master`(`Item_no`,`Item_name`,`Item_Make`,`Item_Rate`,`Item_Ratio`,`Item_Unit`) values 
(1,'Electronic Meter','Secure Ltd.',1204,32,'nos'),
(2,'Joining Kit','Elpro International',440,43,'nos'),
(3,'Trasformers','Secure Ltd.',10000,44,'nos'),
(4,'Numerical Relay','Elpro International',78798,43,'nos'),
(5,'Cables','Secure Ltd.',9000,343,'roll'),
(6,'66 KV Isolators','Raychem',7800,87,'nos'),
(7,'Changeover & Bypass Switch','Kayfs / Shakti',2300,86,'nos'),
(8,'CT Block','ABB',2500,88,'nos.'),
(9,'Transformer Oil','Apar Inds. /  Raj Petro.',200,45,'Liter'),
(10,'IRON','TATA',2000,765,'KG'),
(11,'1213232','3232',3232,NULL,''),
(12,'jjgsff','tra',2345,23,'kg');

/*Table structure for table `item_sold` */

DROP TABLE IF EXISTS `item_sold`;

CREATE TABLE `item_sold` (
  `Bill_No` int(11) DEFAULT NULL,
  `Item_No` int(11) DEFAULT NULL,
  `Item_Name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Make` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Item_Srno` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Unit_Price` int(11) DEFAULT NULL,
  `Unit_Quantity` int(11) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_sold` */

insert  into `item_sold`(`Bill_No`,`Item_No`,`Item_Name`,`Item_Make`,`Item_Srno`,`Unit_Price`,`Unit_Quantity`,`Total`) values 
(1,2,'Joining Kit','Elpro International','3333',440,3,1320),
(1,2,'Joining Kit','Elpro International','22',440,22,9680),
(1,1,'Electronic Meter','Secure Ltd.','222',1204,3,3612),
(1,1,'Electronic Meter','Secure Ltd.','22',1204,3,3612),
(1,3,'Trasformers','Secure Ltd.','2',10000,3,30000),
(1,3,'Trasformers','Secure Ltd.','3',10000,3,30000),
(2,4,'Numerical Relay','Elpro International','33',78798,4,315192),
(3,3,'Trasformers','Secure Ltd.','3',10000,4,40000),
(4,2,'Joining Kit','Elpro International','2',440,2,880),
(5,3,'Trasformers','Secure Ltd.','2',10000,2,20000),
(5,3,'Trasformers','Secure Ltd.','111',10000,3,30000),
(5,3,'Trasformers','Secure Ltd.','44',10000,3,30000),
(6,1,'Electronic Meter','Secure Ltd.','23',1204,4,4816),
(7,6,'66 KV Isolators','Raychem','111',7800,1,7800),
(7,6,'66 KV Isolators','Raychem','111',7800,1,7800),
(7,3,'Trasformers','Secure Ltd.','123',10000,2,20000),
(8,2,'Joining Kit','Elpro International','22342',440,2,880),
(9,6,'66 KV Isolators','Raychem','123',7800,2,15600),
(10,3,'Trasformers','Secure Ltd.','232',10000,2,20000),
(11,2,'Joining Kit','Elpro International','213',440,3,1320),
(11,3,'Trasformers','Secure Ltd.','1232',10000,2,20000),
(11,6,'66 KV Isolators','Raychem','2323',7800,2,15600),
(11,2,'Joining Kit','Elpro International','123',440,4,1760),
(11,2,'Joining Kit','Elpro International','345',440,4,1760),
(12,5,'Cables','Secure Ltd.','2213',9000,4,36000),
(12,2,'Joining Kit','Elpro International','23',440,5,2200),
(12,4,'Numerical Relay','Elpro International','234',78798,4,315192),
(12,4,'Numerical Relay','Elpro International','24',78798,4,315192),
(13,2,'Joining Kit','Elpro International','23133',440,3,1320),
(14,4,'Numerical Relay','Elpro International','346',78798,8,630384);

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `Vendorid` varchar(50) NOT NULL,
  `Name` varchar(35) DEFAULT NULL,
  `Contactno` varchar(15) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Items` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `items` */

insert  into `items`(`Vendorid`,`Name`,`Contactno`,`Date`,`Items`) values 
('05','Manoj','8285591940','2013-07-17','Engine Oil\nOil Filter\n'),
('05','Manoj','8285591940','2013-07-17','Engine Oil,Oil Filter\n'),
('05','Manoj','8285591940','2013-07-17','Air Filter, Diesel Filter, Wiper, Break Parts, Power Steering, Gear oil, Break oil, Break shol, Head Light Bulb, Spark Plug, '),
('46411','bjguygjh','9015506290','2013-07-17','Engine Oil, Oil Filter, Air Filter, ');

/*Table structure for table `newvendor` */

DROP TABLE IF EXISTS `newvendor`;

CREATE TABLE `newvendor` (
  `Vendorid` varchar(30) NOT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `Contactno` varchar(12) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Vendorid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `newvendor` */

insert  into `newvendor`(`Vendorid`,`Name`,`Contactno`,`Date`) values 
('01','Rajiv','8285591940','2013-07-17'),
('02','Rajiv','8285591940','2013-07-17'),
('03','Niru','85693','2013-07-17'),
('05','Manoj','8285591940','2013-07-17'),
('V05','fgh','1234567890','2014-01-15'),
('V06','kk','1234567898','2014-09-23'),
('V07','kkk','8595232601','2014-09-23');

/*Table structure for table `part_master` */

DROP TABLE IF EXISTS `part_master`;

CREATE TABLE `part_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `partname` varchar(200) DEFAULT NULL,
  `partcost` decimal(18,2) DEFAULT NULL,
  `partsalecost` decimal(18,2) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `purchaseDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `warranty` varchar(200) DEFAULT NULL,
  `Category` varchar(100) DEFAULT NULL,
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `part_master` */

insert  into `part_master`(`ID`,`partname`,`partcost`,`partsalecost`,`qty`,`purchaseDate`,`warranty`,`Category`) values 
(1,'abc','400.00','500.00',2,'2017-05-06 17:28:31','1 year','Air Filter'),
(2,'abc kkk','400.00','400.00',2,'2017-05-06 17:31:08','3','Air Filter'),
(3,'abc','400.00','500.00',2,'2017-05-06 17:32:49','3','Air Filter'),
(4,'ram ji','400.00','500.00',4,'2017-05-06 18:47:06','3','Air Filter'),
(5,'Rajesh kumar','400.00','500.00',4,'2017-05-06 18:49:36','3','Air Filter');

/*Table structure for table `partsdetail` */

DROP TABLE IF EXISTS `partsdetail`;

CREATE TABLE `partsdetail` (
  `parts` varchar(40) NOT NULL,
  `purchasecost` varchar(45) NOT NULL,
  `salecost` varchar(45) NOT NULL,
  `item` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `partsdetail` */

insert  into `partsdetail`(`parts`,`purchasecost`,`salecost`,`item`) values 
('Saleparts','1021','0','Wiper,Power Steering,Gear oil,Break oil,'),
('Purchaseparts','10210','0','Wiper,Power Steering,Gear oil,Break oil,'),
('Purchaseparts','254012','21542','Power Steering,Gear oil,Break oil,'),
('Saleparts','54','10','Wiper,Power Steering,'),
('Purchaseparts','120','0','Gear oil,Break oil,Break shol,'),
('Saleparts','0','100','Power Steering,Gear oil,'),
('Purchaseparts','254','0','Wiper,'),
('Saleparts','0','250','Power Steering,Gear oil,Belts,'),
('Purchaseparts','240','0','Gear oil,Break oil,Break shol,'),
('Saleparts','0','240','Power Steering,Gear oil,Break oil,Break shol,');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
