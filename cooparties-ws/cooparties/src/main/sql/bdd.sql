-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.5.34 - MySQL Community Server (GPL)
-- Serveur OS:                   Win32
-- HeidiSQL Version:             8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour cooparties
CREATE DATABASE IF NOT EXISTS `cooparties` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cooparties`;


-- Export de la structure de table cooparties. evenement
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_type_jeu` int(10) unsigned DEFAULT NULL,
  `etat` enum('CONFIRME','ANNULE','ATTENTE') NOT NULL,
  `jeu` varchar(100) NOT NULL,
  `id_organisateur` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `date_creation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `adresse` varchar(500) DEFAULT NULL,
  `code_postal` int(5) unsigned NOT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `modalites` varchar(1000) DEFAULT NULL,
  `nb_participants_max` int(4) unsigned DEFAULT NULL,
  `id_support` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_evenement_utilisateur` (`id_organisateur`),
  KEY `FK_evenement_type_jeu` (`id_type_jeu`),
  KEY `FK_evenement_support` (`id_support`),
  CONSTRAINT `FK_evenement_support` FOREIGN KEY (`id_support`) REFERENCES `support` (`id`),
  CONSTRAINT `FK_evenement_type_jeu` FOREIGN KEY (`id_type_jeu`) REFERENCES `type_jeu` (`id`),
  CONSTRAINT `FK_evenement_utilisateur` FOREIGN KEY (`id_organisateur`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.evenement: ~0 rows (environ)
DELETE FROM `evenement`;
/*!40000 ALTER TABLE `evenement` DISABLE KEYS */;
INSERT INTO `evenement` (`id`, `id_type_jeu`, `etat`, `jeu`, `id_organisateur`, `date`, `heure`, `date_creation`, `adresse`, `code_postal`, `ville`, `modalites`, `nb_participants_max`, `id_support`) VALUES
	(1, 1, 'CONFIRME', 'tekken', 1, '2014-05-16', '22:44:11', '2014-05-16 22:47:26', '22 avenue de la republique', 75011, 'paris', 'c\'est des modalites', 5, 1);
/*!40000 ALTER TABLE `evenement` ENABLE KEYS */;


-- Export de la structure de table cooparties. evenement_participant
CREATE TABLE IF NOT EXISTS `evenement_participant` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `etat` enum('ACCEPTE','ATTENTE','REFUSE','ANNULE') NOT NULL,
  `id_participant` int(10) unsigned NOT NULL,
  `id_evenement` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utilisateur` (`id_participant`),
  KEY `FK_evenement` (`id_evenement`),
  CONSTRAINT `FK__evenement` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id`),
  CONSTRAINT `FK__utilisateur` FOREIGN KEY (`id_participant`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.evenement_participant: ~0 rows (environ)
DELETE FROM `evenement_participant`;
/*!40000 ALTER TABLE `evenement_participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `evenement_participant` ENABLE KEYS */;


-- Export de la structure de table cooparties. support
CREATE TABLE IF NOT EXISTS `support` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.support: ~0 rows (environ)
DELETE FROM `support`;
/*!40000 ALTER TABLE `support` DISABLE KEYS */;
INSERT INTO `support` (`id`, `libelle`) VALUES
	(1, 'Playstation'),
	(2, 'Playstation 2'),
	(3, 'Playstation 3'),
	(4, 'Playstation 4'),
	(5, 'XBox'),
	(6, 'XBox 360'),
	(7, 'PC'),
	(8, 'Plateau'),
	(9, 'Scrabble');
/*!40000 ALTER TABLE `support` ENABLE KEYS */;


-- Export de la structure de table cooparties. type_jeu
CREATE TABLE IF NOT EXISTS `type_jeu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.type_jeu: ~9 rows (environ)
DELETE FROM `type_jeu`;
/*!40000 ALTER TABLE `type_jeu` DISABLE KEYS */;
INSERT INTO `type_jeu` (`id`, `libelle`) VALUES
	(1, 'Combat'),
	(2, 'FPS'),
	(3, 'Sport'),
	(4, 'Stratégie');
/*!40000 ALTER TABLE `type_jeu` ENABLE KEYS */;


-- Export de la structure de table cooparties. utilisateur
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `utilisateur` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avatar` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index 2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.utilisateur: ~1 rows (environ)
DELETE FROM `utilisateur`;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`id`, `utilisateur`, `mdp`, `email`, `avatar`) VALUES
	(1, 'toto', 'mdp', 'email', 'avatar');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;


-- Export de la structure de table cooparties. utilisateur_messages
CREATE TABLE IF NOT EXISTS `utilisateur_messages` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_evenement` int(10) unsigned NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `id_destinataire` int(10) unsigned NOT NULL,
  `id_expediteur` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__destinataire_message` (`id_destinataire`),
  KEY `FK__expediteur_message` (`id_expediteur`),
  KEY `FK__evenement_message` (`id_evenement`),
  CONSTRAINT `FK__destinataire_message` FOREIGN KEY (`id_destinataire`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FK__evenement_message` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id`),
  CONSTRAINT `FK__expediteur_message` FOREIGN KEY (`id_expediteur`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table cooparties.utilisateur_messages: ~0 rows (environ)
DELETE FROM `utilisateur_messages`;
/*!40000 ALTER TABLE `utilisateur_messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur_messages` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
