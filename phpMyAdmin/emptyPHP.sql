-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : dim. 15 jan. 2023 à 21:26
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

-- --------------------------------------------------------

--
-- Structure de la table `Jour`
--

CREATE TABLE `Jour` (
  `idJour` int(1) NOT NULL,
  `jour` datetime NOT NULL,
  `#dvalue` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
  MODIFY `idValue` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

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
