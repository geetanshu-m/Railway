-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2017 at 08:09 PM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `railway_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `journey_details`
--

CREATE TABLE IF NOT EXISTS `journey_details` (
`Sno` int(10) NOT NULL,
  `from_station` varchar(25) NOT NULL,
  `to_station` varchar(25) NOT NULL,
  `j_date` date NOT NULL,
  `Ticket_type` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `journey_details`
--

INSERT INTO `journey_details` (`Sno`, `from_station`, `to_station`, `j_date`, `Ticket_type`) VALUES
(1, 'Jaipur', 'Chennai', '2017-07-08', 'E-ticket'),
(2, 'Mumbai', 'Chennai', '2017-08-05', 'E-ticket'),
(3, 'Jaipur', 'Mumbai', '2017-09-16', 'E-ticket');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
`Sno` int(10) NOT NULL,
  `fname` varchar(25) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(150) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(25) NOT NULL,
  `mob` int(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Sno`, `fname`, `lname`, `dob`, `address`, `email`, `password`, `mob`) VALUES
(1, 'Priya', 'Agarwal', '1996-06-12', 'Mumbai', 'priya@gmail.com', '123456789', 2147483647),
(2, 'Riya', 'Malhotra', '1987-08-17', 'Pune, India', 'riyam@gmail.com', 'riya09876', 78933245),
(4, 'Raj', 'Mehra', '1987-09-18', 'Haryana', 'rajmehra@gmail.com', 'rajmehra', 89878675),
(5, 'Arjun', 'Nehra', '1967-12-09', 'Mount Abu, Rajasthan', 'arjunnehra@gmail.com', 'arjunnehra', 98865645),
(6, 'Hema', 'Sharma', '1964-02-16', 'Jaipur', 'hema@yahoo.com', 'hema54321', 897865535);

-- --------------------------------------------------------

--
-- Table structure for table `passenger_details`
--

CREATE TABLE IF NOT EXISTS `passenger_details` (
`Sno` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(3) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Nationality` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passenger_details`
--

INSERT INTO `passenger_details` (`Sno`, `Name`, `Age`, `Gender`, `Nationality`) VALUES
(1, 'Shreyas', 28, 'null', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `payment_details`
--

CREATE TABLE IF NOT EXISTS `payment_details` (
`Sno` int(10) NOT NULL,
  `Card_no` int(16) NOT NULL,
  `CH_name` varchar(30) NOT NULL,
  `Bank` varchar(100) NOT NULL,
  `Amount` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_details`
--

INSERT INTO `payment_details` (`Sno`, `Card_no`, `CH_name`, `Bank`, `Amount`) VALUES
(1, 687302974, 'Shreyas', 'OBC', 908);

-- --------------------------------------------------------

--
-- Table structure for table `train_detail`
--

CREATE TABLE IF NOT EXISTS `train_detail` (
  `Train_no` varchar(6) NOT NULL,
  `Train_name` varchar(25) NOT NULL,
  `from_station` varchar(25) NOT NULL,
  `Dep_time` time(5) NOT NULL,
  `To_station` varchar(25) NOT NULL,
  `Arriv_time` time(5) NOT NULL,
  `Dist` float NOT NULL,
  `Travel_time` time(5) NOT NULL,
  `Quota` varchar(15) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train_detail`
--

INSERT INTO `train_detail` (`Train_no`, `Train_name`, `from_station`, `Dep_time`, `To_station`, `Arriv_time`, `Dist`, `Travel_time`, `Quota`, `Price`) VALUES
('BC0211', 'Chennai Rath', 'Bengaluru', '03:00:00.00000', 'Chennai', '05:15:00.00000', 150, '02:15:00.00000', 'General', 756),
('BC0212', 'Fast Express', 'Bengaluru', '18:35:00.00000', 'Chennai', '21:00:00.00000', 225, '02:25:00.00000', 'General', 890),
('BC0213', 'Bengaluru Express', 'Bengaluru', '08:00:00.00000', 'Chennai', '11:00:00.00000', 170, '03:00:00.00000', 'Physically Hand', 845),
('BC0214', 'Superb Express', 'Bengaluru', '05:40:00.00000', 'Chennai', '08:00:00.00000', 156, '02:20:00.00000', 'Ladies', 655),
('BJ7015', 'Bengaluru Express', 'Bengaluru', '06:25:00.00000', 'Jaipur', '22:50:00.00000', 765, '16:25:00.00000', 'General', 967),
('BJ7016', 'Jaipur Express', 'Bengaluru', '01:15:00.00000', 'Jaipur', '15:00:00.00000', 740, '16:45:00.00000', 'General', 987),
('BJ7017', 'Fast Express', 'Bengaluru', '03:00:00.00000', 'Jaipur', '16:00:00.00000', 689, '13:00:00.00000', 'Physically Hand', 950),
('BJ7018', 'Superb Express', 'Bengaluru', '08:00:00.00000', 'Jaipur', '21:30:00.00000', 678, '13:30:00.00000', 'Ladies', 1430),
('BM0231', 'Mumbai Express', 'Bengaluru', '05:15:00.00000', 'Mumbai', '09:25:00.00000', 356, '04:10:00.00000', 'General', 850),
('BM0232', 'Bengaluru Express', 'Bengaluru', '10:30:00.00000', 'Mumbai', '15:00:00.00000', 350, '04:30:00.00000', 'General', 790),
('BM0233', 'Superb Express', 'Bengaluru', '11:40:00.00000', 'Mumbai', '16:00:00.00000', 350, '04:20:00.00000', 'Physically Hand', 810),
('BM0234', 'Fast Express', 'Bengaluru', '05:00:00.00000', 'Mumbai', '09:00:00.00000', 350, '04:00:00.00000', 'Ladies', 855),
('CB0211', 'Bengaluru Express', 'Chennai', '03:00:00.00000', 'Bengaluru', '05:15:00.00000', 150, '02:15:00.00000', 'General', 657),
('CB0212', 'Fast Express', 'Chennai', '18:35:00.00000', 'Bengaluru', '21:00:00.00000', 225, '02:25:00.00000', 'General', 876),
('CB0213', 'Chennai Rath', 'Chennai', '08:00:00.00000', 'Bengaluru', '11:00:00.00000', 170, '03:00:00.00000', 'Physically Hand', 907),
('CB0214', 'Superb Express', 'Chennai', '05:40:00.00000', 'Bengaluru', '08:00:00.00000', 156, '02:20:00.00000', 'Ladies', 890),
('CH0021', 'Chennai Rath', 'Chennai', '07:25:00.00000', 'Jaipur', '07:15:00.00000', 832, '22:50:00.00000', 'General', 1789),
('CJ0022', 'Fast Express', 'Chennai', '13:00:00.00000', 'Jaipur', '12:30:00.00000', 867, '23:30:00.00000', 'General', 1870),
('CJ0023', 'Jaipur Express', 'Chennai', '07:25:00.00000', 'Jaipur', '07:25:00.00000', 843, '23:59:00.00000', 'Physically Hand', 1790),
('CJ0024', 'Jaipur Express', 'Chennai', '04:20:00.00000', 'Jaipur', '03:55:00.00000', 802, '23:35:00.00000', 'Ladies', 1986),
('CM1115', 'Chennai Rath', 'Chennai', '05:00:00.00000', 'Mumbai', '14:50:00.00000', 512, '09:50:00.00000', 'General', 1250),
('CM1116', 'Fast Express', 'Chennai', '09:15:00.00000', 'Mumbai', '16:45:00.00000', 495, '07:30:00.00000', 'General', 1190),
('CM1117', 'Mumbai Express', 'Chennai', '12:15:00.00000', 'Mumbai', '21:00:00.00000', 520, '08:45:00.00000', 'Physically Hand', 1225),
('CM1118', 'Mumbai Express', 'Chennai', '09:00:00.00000', 'Mumbai', '16:00:00.00000', 520, '07:00:00.00000', 'Ladies', 1110),
('JB1015', 'Superb Express', 'Jaipur', '06:25:00.00000', 'Bengaluru', '22:50:00.00000', 765, '16:25:00.00000', 'General', 1450),
('JB1016', 'Fast Express', 'Jaipur', '01:15:00.00000', 'Bengaluru', '15:00:00.00000', 740, '16:45:00.00000', 'General', 1546),
('JB1017', 'Bengaluru Express', 'Jaipur', '03:00:00.00000', 'Bengaluru', '16:00:00.00000', 689, '13:00:00.00000', 'Physically Hand', 1650),
('JB1018', 'Bengaluru Express', 'Jaipur', '08:00:00.00000', 'Bengaluru', '21:30:00.00000', 678, '13:30:00.00000', 'Ladies', 1542),
('JC0021', 'Chennai Rath', 'Jaipur', '07:25:00.00000', 'Chennai', '07:15:00.00000', 832, '22:50:00.00000', 'General', 1500),
('JC0022', 'Fast Express', 'Jaipur', '13:00:00.00000', 'Chennai', '12:30:00.00000', 867, '23:30:00.00000', 'General', 1676),
('JC0023', 'Jaipur Express', 'Jaipur', '07:25:00.00000', 'Chennai', '07:25:00.00000', 843, '23:59:00.00000', 'Physically Hand', 1660),
('JC0024', 'Jaipur Express', 'Jaipur', '04:20:00.00000', 'Chennai', '03:55:00.00000', 802, '23:35:00.00000', 'Ladies', 1590),
('JM0011', 'Mumbai Express', 'Jaipur', '14:50:00.00000', 'Mumbai', '05:15:00.00000', 415, '14:25:00.00000', 'General', 1441),
('JM0012', 'Fast Express', 'Jaipur', '05:00:00.00000', 'Mumbai', '17:10:00.00000', 420, '12:10:00.00000', 'General', 1400),
('JM0013', 'Mumbai Express', 'Jaipur', '18:50:00.00000', 'Mumbai', '10:30:00.00000', 420, '15:40:00.00000', 'Physically Hand', 1378),
('JM0014', 'Fast Express', 'Jaipur', '06:40:00.00000', 'Mumbai', '20:40:00.00000', 512, '14:00:00.00000', 'Ladies', 1350),
('MB0231', 'Bengaluru Express', 'Mumbai', '05:15:00.00000', 'Bengaluru', '09:25:00.00000', 356, '04:10:00.00000', 'General', 879),
('MB0232', 'Fast Express', 'Mumbai', '10:30:00.00000', 'Bengaluru', '15:00:00.00000', 350, '04:30:00.00000', 'General', 917),
('MB0233', 'Mumbai Express', 'Mumbai', '11:40:00.00000', 'Bengaluru', '16:00:00.00000', 350, '04:20:00.00000', 'Physically Hand', 850),
('MB0234', 'Fast Express', 'Mumbai', '05:00:00.00000', 'Bengaluru', '09:00:00.00000', 350, '04:00:00.00000', 'Ladies', 860),
('MC1115', 'Chennai Rath', 'Mumbai', '05:00:00.00000', 'Chennai', '14:50:00.00000', 512, '09:50:00.00000', 'General', 1079),
('MC1116', 'Superb Express', 'Mumbai', '09:15:00.00000', 'Chennai', '16:45:00.00000', 495, '07:30:00.00000', 'General', 1190),
('MC1117', 'Mumbai Express', 'Mumbai', '12:15:00.00000', 'Chennai', '21:00:00.00000', 520, '08:45:00.00000', 'Physically Hand', 1170),
('MC1118', 'Superb Express', 'Mumbai', '09:00:00.00000', 'Chennai', '16:00:00.00000', 520, '07:00:00.00000', 'Ladies', 1050),
('MJ2011', 'Mumbai Express', 'Mumbai', '14:50:00.00000', 'Jaipur', '05:15:00.00000', 415, '14:25:00.00000', 'General', 1290),
('MJ2012', 'Fast Express', 'Mumbai', '05:00:00.00000', 'Jaipur', '17:10:00.00000', 420, '12:10:00.00000', 'General', 1298),
('MJ2013', 'Mumbai Express', 'Mumbai', '18:50:00.00000', 'Jaipur', '10:30:00.00000', 420, '15:40:00.00000', 'Physically Hand', 980),
('MJ2014', 'Fast Express', 'Mumbai', '04:30:00.00000', 'Jaipur', '16:40:00.00000', 512, '12:10:00.00000', 'Ladies', 1070);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `journey_details`
--
ALTER TABLE `journey_details`
 ADD PRIMARY KEY (`Sno`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`Sno`,`email`), ADD UNIQUE KEY `mob` (`mob`);

--
-- Indexes for table `passenger_details`
--
ALTER TABLE `passenger_details`
 ADD PRIMARY KEY (`Sno`);

--
-- Indexes for table `payment_details`
--
ALTER TABLE `payment_details`
 ADD PRIMARY KEY (`Sno`);

--
-- Indexes for table `train_detail`
--
ALTER TABLE `train_detail`
 ADD PRIMARY KEY (`Train_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `journey_details`
--
ALTER TABLE `journey_details`
MODIFY `Sno` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
MODIFY `Sno` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `passenger_details`
--
ALTER TABLE `passenger_details`
MODIFY `Sno` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `payment_details`
--
ALTER TABLE `payment_details`
MODIFY `Sno` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
