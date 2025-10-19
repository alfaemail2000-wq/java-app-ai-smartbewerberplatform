-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 24. Jul 2025 um 15:03
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bewerber_db`
--
CREATE DATABASE IF NOT EXISTS `bewerber_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bewerber_db`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bewerberprofile`
--

CREATE TABLE `bewerberprofile` (
  `bewerber_id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `beruf` varchar(60) NOT NULL,
  `jahreerfahrung` int(11) NOT NULL,
  `skill` varchar(70) NOT NULL,
  `abschlussdatum` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Daten für Tabelle `bewerberprofile`
--

INSERT INTO `bewerberprofile` (`bewerber_id`, `name`, `beruf`, `jahreerfahrung`, `skill`, `abschlussdatum`) VALUES
(1, 'Mathias', 'Arzt', 5, 'Zahnmedizin', '2020-07-01'),
(2, 'John', 'Ingenieur ', 1, 'CAD', '2018-07-03'),
(3, 'Tanja', 'Krankenschwester', 4, 'Ambulant', '2020-07-01'),
(4, 'Tomas', 'Techniker', 1, 'Verfahrenstechnik', '2018-07-03'),
(5, 'New Bewerber 1', 'Krankeschw', 60, 'Medikament geben', '2025-01-19'),
(6, 'Anjelina', 'Krankeschw', 60, 'Medikament geben', '2025-01-19'),
(7, 'Test', 'sdf', 4, 'GITARE', '2025-07-10'),
(8, 'Test', 'sdf', 4, 'GITARE', '2025-07-10'),
(9, 'Test', 'sdf', 4, 'GITARE', '2025-07-10'),
(10, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(11, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(12, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(13, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(14, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(15, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(16, 'Test', 'sdf', 4, 'GITARE', '2025-07-11'),
(17, 'Test', 'sdf', 4, 'GITARE', '2025-07-11');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bewerberprofile`
--
ALTER TABLE `bewerberprofile`
  ADD PRIMARY KEY (`bewerber_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bewerberprofile`
--
ALTER TABLE `bewerberprofile`
  MODIFY `bewerber_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
