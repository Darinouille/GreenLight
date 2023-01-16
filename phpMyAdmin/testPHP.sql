-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 16 jan. 2023 à 00:29
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cd006182`
--

-- --------------------------------------------------------

--
-- Structure de la table `Heure`
--

CREATE TABLE `Heure` (
  `idValue` int(1) NOT NULL,
  `pas` int(2) NOT NULL,
  `hvalue` int(1) NOT NULL,
  `#idJour` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Heure`
--

INSERT INTO `Heure` (`idValue`, `pas`, `hvalue`, `#idJour`) VALUES
(1, 0, 1, 3),
(2, 1, 1, 3),
(3, 2, 1, 3),
(4, 3, 1, 3),
(5, 4, 1, 3),
(6, 5, 1, 3),
(7, 6, 1, 3),
(8, 7, 1, 3),
(9, 8, 1, 3),
(10, 9, 1, 3),
(11, 10, 1, 3),
(12, 11, 1, 3),
(13, 12, 1, 3),
(14, 13, 1, 3),
(15, 14, 1, 3),
(16, 15, 1, 3),
(17, 16, 1, 3),
(18, 17, 1, 3),
(19, 18, 1, 3),
(20, 19, 1, 3),
(21, 20, 1, 3),
(22, 21, 1, 3),
(23, 22, 1, 3),
(24, 23, 1, 3),
(25, 0, 1, 1),
(26, 1, 1, 1),
(27, 2, 1, 1),
(28, 3, 1, 1),
(29, 4, 1, 1),
(30, 5, 2, 1),
(31, 6, 2, 1),
(32, 7, 3, 1),
(33, 8, 3, 1),
(34, 9, 3, 1),
(35, 10, 3, 1),
(36, 11, 3, 1),
(37, 12, 3, 1),
(38, 13, 2, 1),
(39, 14, 2, 1),
(40, 15, 2, 1),
(41, 16, 2, 1),
(42, 17, 3, 1),
(43, 18, 3, 1),
(44, 19, 3, 1),
(45, 20, 2, 1),
(46, 21, 2, 1),
(47, 22, 2, 1),
(48, 23, 2, 1),
(49, 0, 1, 2),
(50, 1, 1, 2),
(51, 2, 1, 2),
(52, 3, 1, 2),
(53, 4, 1, 2),
(54, 5, 1, 2),
(55, 6, 1, 2),
(56, 7, 2, 2),
(57, 8, 2, 2),
(58, 9, 2, 2),
(59, 10, 2, 2),
(60, 11, 2, 2),
(61, 12, 1, 2),
(62, 13, 1, 2),
(63, 14, 1, 2),
(64, 15, 1, 2),
(65, 16, 1, 2),
(66, 17, 2, 2),
(67, 18, 2, 2),
(68, 19, 1, 2),
(69, 20, 1, 2),
(70, 21, 1, 2),
(71, 22, 1, 2),
(72, 23, 1, 2),
(73, 7, 3, 0),
(74, 8, 3, 0),
(75, 9, 3, 0),
(76, 10, 3, 0),
(77, 11, 3, 0),
(78, 12, 3, 0),
(79, 13, 3, 0),
(80, 14, 2, 0),
(81, 15, 2, 0),
(82, 16, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `Jour`
--

CREATE TABLE `Jour` (
  `idJour` int(1) NOT NULL,
  `jour` datetime NOT NULL,
  `generationFichier` datetime NOT NULL,
  `#dvalue` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Jour`
--

INSERT INTO `Jour` (`idJour`, `jour`, `generationFichier`, `#dvalue`) VALUES
(0, '2022-06-03 00:00:00', '2022-06-03 07:36:25', 3),
(1, '2022-06-04 00:00:00', '2022-06-03 07:36:25', 3),
(2, '2022-06-05 00:00:00', '2022-06-03 07:36:25', 2),
(3, '2022-06-06 00:00:00', '2022-06-03 07:36:25', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Message`
--

CREATE TABLE `Message` (
  `dValue` int(1) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Message`
--

INSERT INTO `Message` (`dValue`, `message`) VALUES
(1, 'Situation normale '),
(2, 'Risque de coupures d\'électricité'),
(3, 'Coupures d\'électricité programmées');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Heure`
--
ALTER TABLE `Heure`
  ADD PRIMARY KEY (`idValue`);

--
-- Index pour la table `Jour`
--
ALTER TABLE `Jour`
  ADD PRIMARY KEY (`idJour`);

--
-- Index pour la table `Message`
--
ALTER TABLE `Message`
  ADD PRIMARY KEY (`dValue`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Heure`
--
ALTER TABLE `Heure`
  MODIFY `idValue` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT pour la table `Message`
--
ALTER TABLE `Message`
  MODIFY `dValue` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

--
-- Jointure entre les tables
--
SELECT `idJour`, `#dvalue` FROM `Jour`
INNER JOIN `Heure` ON `#idJour`=`idJour`
INNER JOIN `Message` ON `dvalue`=`#dvalue`

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
