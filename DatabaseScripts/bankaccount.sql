-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 22, 2018 at 06:44 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SampleAccount`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_accountbalance`
--

CREATE TABLE `tbl_accountbalance` (
  `id` int(11) NOT NULL,
  `accountnumber` varchar(100) NOT NULL,
  `balance` decimal(60,0) NOT NULL,
  `timestamp` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_accountbalance`
--

INSERT INTO `tbl_accountbalance` (`id`, `accountnumber`, `balance`, `timestamp`) VALUES
(3, '1111', '48500', '2018-03-15 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_deposit`
--

CREATE TABLE `tbl_deposit` (
  `id` int(11) NOT NULL,
  `accountnumber` varchar(500) NOT NULL,
  `depositamount` decimal(60,0) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `flag` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_deposit`
--

INSERT INTO `tbl_deposit` (`id`, `accountnumber`, `depositamount`, `timestamp`, `flag`) VALUES
(7, '1111', '20000', '2018-03-01 00:00:00.000000', 1),
(8, '1111', '15000', '2018-03-22 10:11:16.000000', 0),
(9, '1111', '3000', '2018-03-22 10:31:50.000000', 1),
(10, '1111', '13000', '2018-03-22 10:32:09.000000', 2),
(11, '1111', '10000', '2018-03-22 11:20:12.000000', 1),
(12, '1111', '10000', '2018-03-22 11:20:26.000000', 1),
(13, '1111', '10000', '2018-03-22 11:48:32.000000', 2),
(17, '1111', '4000', '2018-03-22 07:08:39.000000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_totaldeposit`
--

CREATE TABLE `tbl_totaldeposit` (
  `id` int(11) NOT NULL,
  `accountnumber` varchar(200) NOT NULL,
  `totaldeposit` decimal(60,0) NOT NULL,
  `timestamp` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_totaldeposit`
--

INSERT INTO `tbl_totaldeposit` (`id`, `accountnumber`, `totaldeposit`, `timestamp`) VALUES
(1, '1111', '75200', '2018-03-22 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_totalwithdrawl`
--

CREATE TABLE `tbl_totalwithdrawl` (
  `id` int(11) NOT NULL,
  `accountnumber` varchar(200) NOT NULL,
  `totalwithdrawl` decimal(60,0) NOT NULL,
  `timestamp` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_totalwithdrawl`
--

INSERT INTO `tbl_totalwithdrawl` (`id`, `accountnumber`, `totalwithdrawl`, `timestamp`) VALUES
(0, '1111', '-14700', '2018-03-22 17:35:01.220067');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_withdrawl`
--

CREATE TABLE `tbl_withdrawl` (
  `id` int(11) NOT NULL,
  `accountnumber` varchar(500) NOT NULL,
  `withdrawlamount` decimal(60,0) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `flag` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_withdrawl`
--

INSERT INTO `tbl_withdrawl` (`id`, `accountnumber`, `withdrawlamount`, `timestamp`, `flag`) VALUES
(2, '1111', '1000', '2018-03-22 00:00:00.000000', 0),
(6, '1111', '3000', '2018-03-22 11:47:51.000000', 1),
(11, '1111', '4000', '2018-03-22 08:34:09.000000', 2),
(12, '1111', '12000', '2018-03-22 08:35:01.000000', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_accountbalance`
--
ALTER TABLE `tbl_accountbalance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_deposit`
--
ALTER TABLE `tbl_deposit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_totaldeposit`
--
ALTER TABLE `tbl_totaldeposit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_withdrawl`
--
ALTER TABLE `tbl_withdrawl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_accountbalance`
--
ALTER TABLE `tbl_accountbalance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_deposit`
--
ALTER TABLE `tbl_deposit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_totaldeposit`
--
ALTER TABLE `tbl_totaldeposit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_withdrawl`
--
ALTER TABLE `tbl_withdrawl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
