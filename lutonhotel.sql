-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2023 at 07:46 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lutonhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `barservice`
--

CREATE TABLE `barservice` (
  `BarID` int(10) NOT NULL,
  `BarMenu` varchar(50) NOT NULL,
  `DrinkPrice` int(10) NOT NULL,
  `BookingID` int(10) NOT NULL,
  `EmployeeID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barservice`
--

INSERT INTO `barservice` (`BarID`, `BarMenu`, `DrinkPrice`, `BookingID`, `EmployeeID`) VALUES
(201, 'Margarita', 600, 310, 101),
(202, 'Pomegranate Margarita', 750, 310, 101),
(203, 'Beer', 450, 310, 101),
(204, 'Beer', 450, 310, 101),
(205, 'Johnnie Walker Label', 4000, 308, 101),
(206, 'Cognac', 2000, 308, 101),
(207, 'Tequila', 10000, 308, 101),
(212, 'Margarita', 1500, 320, 101),
(213, 'Paradise Punch', 1500, 320, 101),
(214, 'Pomegranate Margarita', 500, 320, 101),
(215, 'Orange Juice', 500, 320, 101);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `BookingID` int(10) NOT NULL,
  `CheckInDate` date NOT NULL,
  `CheckOutDate` date NOT NULL,
  `RoomType` varchar(50) NOT NULL,
  `BookingStatus` varchar(50) NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `RoomNo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`BookingID`, `CheckInDate`, `CheckOutDate`, `RoomType`, `BookingStatus`, `CustomerID`, `RoomNo`) VALUES
(308, '2023-05-16', '2023-05-31', 'Single', 'Inactive', 24, 800),
(310, '2023-05-12', '2023-05-19', 'Presidential Suite', 'Inactive', 1, 806),
(311, '2023-05-08', '2023-05-15', 'Queen', 'Inactive', 24, 804),
(314, '2023-05-09', '2023-05-17', 'King', 'Pending', 31, 0),
(320, '2023-05-09', '2023-05-17', 'Double', 'Inactive', 36, 801);

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `BookingID` int(10) NOT NULL,
  `BillingID` int(10) NOT NULL,
  `FullName` varchar(50) NOT NULL,
  `CheckInDate` date NOT NULL,
  `CheckOutDate` date NOT NULL,
  `StayedDays` int(10) NOT NULL,
  `DrinkAmount` int(10) DEFAULT NULL,
  `ServiceAmount` int(10) DEFAULT NULL,
  `FoodAmount` int(10) DEFAULT NULL,
  `RoomAmount` int(10) NOT NULL,
  `SubTotalAmount` double(10,1) NOT NULL,
  `Discount` double(10,1) NOT NULL,
  `GrandTotal` double(10,1) NOT NULL,
  `BillingStatus` varchar(20) NOT NULL,
  `EmployeeID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`BookingID`, `BillingID`, `FullName`, `CheckInDate`, `CheckOutDate`, `StayedDays`, `DrinkAmount`, `ServiceAmount`, `FoodAmount`, `RoomAmount`, `SubTotalAmount`, `Discount`, `GrandTotal`, `BillingStatus`, `EmployeeID`) VALUES
(310, 402, 'Sanjeev Shrestha', '2023-05-12', '2023-05-19', 7, 2250, 9600, 6600, 105000, 125998.6, 13999.9, 139998.5, 'Paid', 101),
(311, 403, 'Yaman Maharjan', '2023-05-08', '2023-05-15', 7, 0, 0, 0, 63000, 64521.0, 7169.0, 71690.0, 'Paid', 101),
(308, 404, 'Yaman Maharjan', '2023-05-16', '2023-05-31', 15, 16000, 18500, 20500, 30000, 86895.0, 9655.0, 96550.0, 'Paid', 101),
(320, 406, 'Ramila Nayaj', '2023-05-09', '2023-05-17', 8, 4000, 9000, 6500, 28000, 48757.5, 5417.5, 54175.0, 'Paid', 101);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(10) NOT NULL,
  `FullName` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `District` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `Postcode` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `EmailID` varchar(50) NOT NULL,
  `MobileNo` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `AccountType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `FullName`, `Address`, `District`, `State`, `Postcode`, `Country`, `EmailID`, `MobileNo`, `Username`, `Password`, `AccountType`) VALUES
(1, 'Sanjeev Shrestha', 'Bigu', 'Dolakha', 'Bagmati', '46600', 'Nepal', 'xanjvstha@gmail.com', '9851225093', 'xanjvstha', 'Sanjeev123', 'Customer'),
(3, 'Avaya Dangol', 'Chandragiri', 'Kathmandu', 'Bagmati', '44500', 'Nepal', 'avaya@gmail.com', '9801012345', 'avayad', 'avaya123', 'Customer'),
(4, 'Aayush Shrestha', 'Payatar', 'Kathmandu', 'Bagmati', '44500', 'Nepal', 'aayush@gmail.com', '9861012345', 'aayushs', 'aayush123', 'Customer'),
(5, 'Ram Shrestha', 'Maitidevi', 'Dolakha', 'Bagmati', '46600', 'Nepal', 'rams@gmail.com', '9851012354', 'ramstha', 'ramstha123', 'Customer'),
(9, 'Dev Ale', 'Sanepa', 'Bhaktapur', 'Bagmati', '44500', 'Nepal', 'dev@gmail.com', '9841013579', 'devale', 'dev123', 'Customer'),
(13, 'Visma Poudel', 'Kalanki', 'Kathmandu', 'Bagmati', '44600', 'Nepal', 'visma@gmail.com', '9841112233', 'vismap', 'visma123', 'Customer'),
(15, 'Kenny Shrestha', 'Charikot', 'Dolakha', 'Bagmati', '45600', 'Nepal', 'kenny@gmail.com', '9851414121', 'kenny', 'kenny123', 'Customer'),
(17, 'Govin Shrestha', 'Sallaghari', 'Bhaktapur', 'Bagmati', '45500', 'Nepal', 'govin@gmail.com', '9861123456', 'govins', 'govin123', 'Customer'),
(22, 'Patan College', 'Kupondol', 'Lalitpur', 'Bagmati', '44500', 'Nepal', 'pcps@gmail.com', '9801011223', 'patancollege', 'patan123', 'Corporate Customer'),
(23, 'Ruchit Shrestha', 'Bigu', 'Dolakha', 'Bagmati', '56700', 'Nepal', 'ruchit@gmail.com', '9841993728', 'ruchit', 'ruchit123', 'Customer'),
(24, 'Yaman Maharjan', 'Naxal', 'Kathmandju', 'Bagmati', '44600', 'Nepal', 'yaman@gmail.com', '9744112233', 'yamanm', 'yaman123', 'Customer'),
(25, 'Sunil Shrestha', 'Maitidevi', 'Kathmandu', 'Bagmati', '44600', 'Nepal', 'sunils@gmail.com', '9841345678', 'sunils', 'sunil123', 'Customer'),
(26, 'Shristi Lama', 'Kandaghari', 'Kathmandu', 'Bagmati', '45600', 'Nepal', 'shristi@gmail.com', '9801011223', 'shristi', 'shristi123', 'Customer'),
(27, 'Ramesh Khadka', 'Banepa', 'Kavre', 'Bagmati', '45700', 'Nepal', 'ramesh@gmail.com', '9841556677', 'ramesh', 'Ramesh123', 'Customer'),
(31, 'Ramesh Shrestha', 'Kapan', 'Kathmandu', 'Bagmati', '44500', 'Nepal', 'ramesh@gmail.com', '9886112233', 'ramesh', 'Ramesh123', 'Customer'),
(32, 'Yamuna Maharjan', 'Charikot', 'Dolakha', 'Bagmati', '4600', 'Nepal', 'yamuna@gmail.com', '9811223344', 'yamuna', 'Yamuna123', 'Customer'),
(36, 'Ramila Nayaj', 'Kapan', 'Kathmandu', 'Bagmati', '544666', 'Nepal', 'ramila@gmail.com', '9841059093', 'ramilan', 'Ramila123', 'Customer'),
(37, 'Patan College', 'Patan', 'Lalitpur', 'Bagmati', '45600', 'Nepal', 'patan@gmail.com', '9844332211', 'patancoll', 'Patan123', 'Corporate Customer');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` int(10) NOT NULL,
  `Emp_FullName` varchar(50) NOT NULL,
  `Emp_EmailID` varchar(50) NOT NULL,
  `Emp_MobileNo` varchar(50) NOT NULL,
  `Emp_Address` varchar(50) NOT NULL,
  `Emp_Username` varchar(50) NOT NULL,
  `Emp_Password` varchar(50) NOT NULL,
  `Emp_Role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `Emp_FullName`, `Emp_EmailID`, `Emp_MobileNo`, `Emp_Address`, `Emp_Username`, `Emp_Password`, `Emp_Role`) VALUES
(100, 'Sudip Parajuli', 'sudip@gmail.com', '9860123456', 'Kavre Nepal', 'sudip', 'Sudip123', 'Manager'),
(101, 'Kripa Nepali', 'kripa@gmail.com', '9801812345', 'Godawori', 'kripan', 'kripa123', 'Receptionist'),
(102, 'Apsana Khadka', 'apsana@gmail.com', '9844091220', 'Charikot', 'apsana', 'apsana123', 'Manager'),
(103, 'Bal Krishna Budathoki', 'balkrishna@gmail.com', '9862123456', 'Baneshwor', 'balkrishna', 'balkrishna123', 'Restaurant Staff'),
(105, 'Ram Karki', 'ramk@gmail.com', '9811335566', 'Kapantar', 'ramkr', 'Ramkarki123', 'Restaurant Staff');

-- --------------------------------------------------------

--
-- Table structure for table `extraservice`
--

CREATE TABLE `extraservice` (
  `ServiceID` int(10) NOT NULL,
  `ServiceType` varchar(50) NOT NULL,
  `ServicePrice` int(10) NOT NULL,
  `BookingID` int(10) NOT NULL,
  `EmployeeID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `extraservice`
--

INSERT INTO `extraservice` (`ServiceID`, `ServiceType`, `ServicePrice`, `BookingID`, `EmployeeID`) VALUES
(501, 'Laundray', 600, 310, 101),
(502, 'Spa and Sauna', 2500, 310, 101),
(503, 'Transportation', 1500, 310, 101),
(504, 'Massage', 5000, 310, 101),
(505, 'Laundray', 1500, 308, 101),
(506, 'Swimming', 500, 308, 101),
(507, 'Gym Fitness', 1500, 308, 101),
(508, 'Spa and Sauna', 5500, 308, 101),
(509, 'Massage', 6500, 308, 101),
(510, 'Hiking', 1500, 308, 101),
(511, 'Transportation', 1500, 308, 101),
(516, 'Laundray', 500, 320, 101),
(517, 'Swimming', 500, 320, 101),
(518, 'Spa and Sauna', 5000, 320, 101),
(519, 'Transportation', 3000, 320, 101);

-- --------------------------------------------------------

--
-- Table structure for table `foodservice`
--

CREATE TABLE `foodservice` (
  `FoodID` int(10) NOT NULL,
  `FoodMenu` varchar(50) NOT NULL,
  `FoodPrice` int(10) NOT NULL,
  `BookingID` int(10) NOT NULL,
  `EmployeeID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodservice`
--

INSERT INTO `foodservice` (`FoodID`, `FoodMenu`, `FoodPrice`, `BookingID`, `EmployeeID`) VALUES
(704, 'Breakfast', 500, 310, 101),
(705, 'Lunch', 1500, 310, 101),
(706, 'BBQ Pork Steak', 1300, 310, 101),
(707, 'Pepperoni Pizza', 1800, 310, 101),
(708, 'Dinner', 1500, 310, 101),
(709, 'Breakfast', 500, 308, 101),
(710, 'Breakfast', 500, 308, 101),
(711, 'Breakfast', 500, 308, 101),
(712, 'Breakfast', 500, 308, 101),
(713, 'Lunch', 1500, 308, 101),
(714, 'Lunch', 1500, 308, 101),
(715, 'Lunch', 1500, 308, 101),
(716, 'Lunch', 1500, 308, 101),
(717, 'Dinner', 1500, 308, 101),
(718, 'Dinner', 1500, 308, 101),
(719, 'Dinner', 1500, 308, 101),
(720, 'Dinner', 1500, 308, 101),
(721, 'Dinner', 1500, 308, 101),
(722, 'Lasagne', 2500, 308, 101),
(723, 'Classic Pizza', 2100, 308, 101),
(724, 'Fried Rice', 400, 308, 101),
(730, 'Breakfast', 500, 320, 101),
(731, 'Lunch', 1500, 320, 101),
(732, 'Dinner', 2000, 320, 101),
(733, 'BBQ Pork Steak', 2500, 320, 101);

-- --------------------------------------------------------

--
-- Table structure for table `roomservice`
--

CREATE TABLE `roomservice` (
  `RoomNo` int(10) NOT NULL,
  `RoomType` varchar(50) NOT NULL,
  `RoomPrice` int(10) NOT NULL,
  `RoomStatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roomservice`
--

INSERT INTO `roomservice` (`RoomNo`, `RoomType`, `RoomPrice`, `RoomStatus`) VALUES
(800, 'Single', 2000, 'Available'),
(801, 'Double', 3500, 'Available'),
(802, 'Twin', 5500, 'Available'),
(803, 'Queen', 7000, 'Available'),
(804, 'King', 9000, 'Available'),
(805, 'Suite', 12000, 'Available'),
(806, 'Presidential Suite', 15000, 'Available'),
(807, 'Single', 3000, 'Available'),
(808, 'Double', 5000, 'Available'),
(809, 'Single', 2000, 'Available'),
(810, 'Double', 3500, 'Available'),
(811, 'Twin', 5500, 'Available'),
(812, 'Double', 4000, 'Available'),
(813, 'Queen', 5000, 'Available'),
(814, 'Queen', 5000, 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barservice`
--
ALTER TABLE `barservice`
  ADD PRIMARY KEY (`BarID`),
  ADD KEY `BookingID` (`BookingID`),
  ADD KEY `fk_EmployeeID` (`EmployeeID`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BookingID`),
  ADD KEY `Customer` (`CustomerID`),
  ADD KEY `RoomNo` (`RoomNo`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`BillingID`),
  ADD KEY `fk_BookingID` (`BookingID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`),
  ADD UNIQUE KEY `EmailID` (`EmailID`,`MobileNo`,`Username`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`),
  ADD UNIQUE KEY `Emp_EmailID` (`Emp_EmailID`),
  ADD UNIQUE KEY `Emp_MobileNo` (`Emp_MobileNo`),
  ADD UNIQUE KEY `Emp_Username` (`Emp_Username`);

--
-- Indexes for table `extraservice`
--
ALTER TABLE `extraservice`
  ADD PRIMARY KEY (`ServiceID`),
  ADD KEY `BookingID` (`BookingID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `foodservice`
--
ALTER TABLE `foodservice`
  ADD PRIMARY KEY (`FoodID`),
  ADD KEY `BookingID` (`BookingID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `roomservice`
--
ALTER TABLE `roomservice`
  ADD PRIMARY KEY (`RoomNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barservice`
--
ALTER TABLE `barservice`
  MODIFY `BarID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=216;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `BookingID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=321;

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `BillingID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=407;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT for table `extraservice`
--
ALTER TABLE `extraservice`
  MODIFY `ServiceID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=520;

--
-- AUTO_INCREMENT for table `foodservice`
--
ALTER TABLE `foodservice`
  MODIFY `FoodID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=734;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barservice`
--
ALTER TABLE `barservice`
  ADD CONSTRAINT `barservice_ibfk_1` FOREIGN KEY (`BookingID`) REFERENCES `booking` (`BookingID`),
  ADD CONSTRAINT `fk_EmployeeID` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);

--
-- Constraints for table `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`),
  ADD CONSTRAINT `fk_BookingID` FOREIGN KEY (`BookingID`) REFERENCES `booking` (`BookingID`);

--
-- Constraints for table `extraservice`
--
ALTER TABLE `extraservice`
  ADD CONSTRAINT `extraservice_ibfk_1` FOREIGN KEY (`BookingID`) REFERENCES `booking` (`BookingID`),
  ADD CONSTRAINT `extraservice_ibfk_2` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `foodservice`
--
ALTER TABLE `foodservice`
  ADD CONSTRAINT `foodservice_ibfk_1` FOREIGN KEY (`BookingID`) REFERENCES `booking` (`BookingID`),
  ADD CONSTRAINT `foodservice_ibfk_2` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
