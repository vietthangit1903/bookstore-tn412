-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2022 at 03:40 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstoretn412`
--
CREATE DATABASE IF NOT EXISTS `bookstoretn412` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bookstoretn412`;

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `description` longtext NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `description`, `name`) VALUES
(1, 'Brandon was born in Bridgeton, NJ in 1991. He started writing in the first grade when his teacher gave him an assignment to write a story that had to do with Halloween. He chose to write a story about werewolves and the rest is history. Since then he\'s written poetry, lyrics to quite a few songs, a ton of reviews on music, movies, video games, etc.', 'Brandon Moore 1'),
(2, 'Colleen Hoover is the #1 New York Times and International bestselling author of multiple novels and novellas. She lives in Texas with her husband and their three boys. She is the founder of The Bookworm Box, a non-profit book subscription service and bookstore in Sulphur Springs, Texas.\r\n\r\nFor more information and for a schedule of events, please visit colleenhoover.com.', 'Colleen Hoover'),
(3, 'Born in Brazil. At the age of 5 I already knew I wanted to draw comics. At 11 I had my first comic strip published in Local newspapers-Frederico, the Detective. At Caliber Press penciled, inked and lettered the HP Lovecraft\'s Dagon, with writer Steven Jones. At Marvel I drew Daredevil, Conan, Thor, Captain America, Disney\'s Quasimodo, Spider-man, the Avengers and others. Drew Batman, Superman, New Gods, Young Heroes in Love, \r\nSuper boy, Steel, Guy Gardner, Hawk man, Man called X, The Flash, Deathstroke, Wonderwoman, Green Arrow, Azrael and others for DC. Taught 7 yrs at the Joe Kubert School. Member of the National Cartoonists Society since 1995.', 'Sergio Cariello'),
(4, 'Dale Carnegie (1888-1955) described himself as a \"simple country boy\" from Missouri but was also a pioneer of the self-improvement genre. Since the 1936 publication of his first book, How to Win Friends and Influence People, he has touched millions of readers and his classic works continue to impact lives to this day.', 'Dale Carnegie'),
(5, 'Stephen R. Covey is a renowned leadership authority, family expert, teacher, organizational consultant, and co-founder of Franklin Covey Co. He is author of several international bestsellers, including The 7 Habits of Highly Effective People, which has sold over 20 million copies. He was named one of TIME Magazine\'s 25 Most Influential Americans. Dr. Covey holds the Jon M. Huntsman Presidential Chair in Leadership at the Huntsman School of Business at Utah State University.', 'Stephen R. Covey'),
(6, 'No description', 'Hunt A Killer'),
(7, 'Steve Martin is one of today\'s most talented performers. His huge successes as a film actor include such credits as ROXANNE, FATHER OF THE BRIDE, PARENTHOOD and THE SPANISH PRISONER. He has won Emmys for his television writing and two Grammys for comedy albums. In addition to the bestselling PURE DRIVEL, he has written several plays, including Picasso at the Lapin Agile and a highly acclaimed novel, SHOPGIRL. His work appears in The New Yorker and The New York Times.', 'Steve Martin'),
(8, 'A graduate of Syracuse University, Jay LaBarge spent his professional career growing companies in the technology industry. A businessman by profession but historian by passion, he and his wife Sandy raised their daughters Ashley and Kara in the Central New York area, with frequent trips to his childhood home in the Adirondack Mountains.\r\n\r\nHe continues to pursue his love of ancient and world history by traveling with his wife to out of the way places both domestically and abroad. His lifetime of curiosity and wanderlust ultimately led to the creation of the Nick LaBounty historical action-adventure series.', 'Jay C. LaBarge'),
(9, 'The Brothers Grimm, Jacob (1785–1863) and Wilhelm (1786–1859), were scholars best known for their lifelong dedication to collecting and publishing ancient German folk tales. Their groundbreaking Kinder- und Hausmärchen (Children’s and Household Tales) was published in seven different editions between 1812 and 1857 and brought to the world’s attention such unforgettable characters as Cinderella, Hansel and Gretel, Rapunzel, and Snow White.', 'Brothers Grimm');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `description` longtext NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(8,2) UNSIGNED NOT NULL,
  `publish_date` date NOT NULL,
  `stock` int(8) UNSIGNED NOT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `description`, `image`, `name`, `price`, `publish_date`, `stock`, `author_id`, `category_id`, `publisher_id`) VALUES
(11, 'Lily and her ex-husband, Ryle, have just settled into a civil coparenting rhythm when she suddenly bumps into her first love, Atlas, again. After nearly two years separated, she is elated that for once, time is on their side, and she immediately says yes when Atlas asks her on a date.', '71PNGYHykrL.jpg', 'It Starts with Us', '18.00', '2022-10-18', 10, 2, 9, 11),
(12, 'Steve Martin has never written about his career in the movies before. In Number One Is Walking, he shares anecdotes from the sets of his beloved films?Father of the Bride, Roxanne, The Jerk, Three Amigos, and many more?bringing readers directly into his world. He shares charming tales of antics, moments of inspiration, and exploits with the likes of Paul McCartney, Diane Keaton, Robin Williams, and Chevy Chase. Martin details his forty years in the movie biz, as well as his stand-up comedy, banjo playing, writing, and cartooning, all with his unparalleled wit.', 'Number One Is Walking 1.jpg', 'Number One Is Walking: My Life in the Movies and Other Diversions', '21.00', '2022-11-15', 12, 7, 7, 12),
(13, 'Dale Carnegie\'s rock-solid, time-tested advice has carried countless people up the ladder of success in their business and personal lives. One of the most groundbreaking and timeless bestsellers of all time,', 'How-Win-Friends-Influence-People-Front-Cover.jpg', 'How to Win Friends & Influence People', '11.00', '1998-01-10', 12, 4, 18, 10),
(14, 'Donald Carlino only cares about three things: money, getting girls, and gambling. His friends are so impressed with his abilities with women, they start calling him Don Juan. When senior year starts, he\'s got a list of girls he wants to add to the growing number of notches on his headboard. So, when his best friend, Thomas, bets Donald that his skills aren\'t enough to nab the school valedictorian, Alaina Pizzo, Donald is up for the challenge. What Thomas doesn\'t know is that Donald has had a crush on Alaina since kindergarten. Problem is, Alaina hates his guts.', 'The Bet Between Us 1.jpg', 'The Bet Between Us', '10.00', '2018-12-28', 12, 1, 9, 2),
(15, 'The year is 1521, and Tenochtitlan burns. Wracked by plague and war, the majestic Aztec empire begins to crumble. As their beloved capital city falls to the ruthless Spaniards and hordes of vengeful tribes, the Aztecs make a last-ditch attempt to secretly save their heritage before it\'s lost to the sands of time forever.', 'Aztec Odyssey 1.jpg', 'Aztec Odyssey: Historical Action Adventure', '20.00', '2021-12-08', 10, 8, 5, 9);

-- --------------------------------------------------------

--
-- Table structure for table `cart_detail`
--

CREATE TABLE `cart_detail` (
  `id` bigint(20) NOT NULL,
  `price` decimal(8,2) UNSIGNED NOT NULL,
  `quantity` int(8) UNSIGNED NOT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(5, 'Action and Adventure'),
(6, 'Classics'),
(7, 'Comic Book or Graphic Novel'),
(8, 'Detective and Mystery'),
(9, 'Fiction'),
(10, 'Historical Fiction'),
(11, 'Horror'),
(12, 'Literary Fiction'),
(13, 'Romance'),
(14, 'Science Fiction (Sci-Fi)'),
(15, 'Short Stories'),
(16, 'History'),
(17, 'Biographies and Autobiographies'),
(18, 'Self-Help');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `payment_method` varchar(255) NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `total_price` decimal(9,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL,
  `price` decimal(8,2) UNSIGNED NOT NULL,
  `quantity` int(8) UNSIGNED NOT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`) VALUES
(1, 'Celadon Books edited'),
(2, 'B. L. Moore'),
(3, 'Canterbury Classics'),
(4, 'Fingerprint Publishing'),
(5, 'Dover Publications'),
(6, 'David C Cook'),
(7, 'Simon & Schuster'),
(8, 'Ulysses Press'),
(9, 'Independently published'),
(10, 'Pocket Books'),
(11, 'Atria'),
(12, 'Celadon Books');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `facebook_id` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) NOT NULL,
  `google_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `facebook_id`, `full_name`, `google_id`, `password`, `role`) VALUES
(1, 'vietthang@nienluan.com', NULL, 'Pham Viet Thang', NULL, '$2a$10$/6..5IgkAxe.5HBpu/oXSOq5Ut/QOTH.GU0GUCVwG.BOHkqXvx3ly', 'Guest'),
(2, 'haitrieu@tn412.com', NULL, 'Nguyen Hai Trieu', NULL, '$2a$10$WqFx7319yjUAsgknUmnvEORzkSBnGRkt5JJXiKoHWOLPSBu68JmJm', 'Guest'),
(3, 'huudan@nienluan.com', NULL, 'Tran Huu Dan', NULL, '$2a$10$zRQ26ouGKXYjAKSW8WJ6S.PDOeOv2TLmLbyeiuCtArFrJtASbAGy6', 'Guest'),
(4, 'congkhang@tn412.com', NULL, 'Van Cong Khang', NULL, '$2a$10$k/D17KIWg89utgHMhwEP0u46ZnVRSxBr76E8GEFLblwuFGBho.Bme', 'Guest');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  ADD KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`),
  ADD KEY `FKgtvt7p649s4x80y6f4842pnfq` (`publisher_id`);

--
-- Indexes for table `cart_detail`
--
ALTER TABLE `cart_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKflpu1psdex9le27p7owju2piw` (`book_id`),
  ADD KEY `FKhqem60okkngoihvdljfclmw48` (`user_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3aceepmpjwpo8pdn7gmjdfckq` (`book_id`),
  ADD KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `cart_detail`
--
ALTER TABLE `cart_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKam9riv8y6rjwkua1gapdfew4j` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKgtvt7p649s4x80y6f4842pnfq` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`);

--
-- Constraints for table `cart_detail`
--
ALTER TABLE `cart_detail`
  ADD CONSTRAINT `FKflpu1psdex9le27p7owju2piw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKhqem60okkngoihvdljfclmw48` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK3aceepmpjwpo8pdn7gmjdfckq` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
