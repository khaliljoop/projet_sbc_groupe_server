-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 28 juil. 2022 à 18:15
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sbc_groupe`
--

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE `activite` (
  `id_activite` int(11) NOT NULL,
  `type_activite` int(11) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `libelle` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `block_user`
--

CREATE TABLE `block_user` (
  `blocked_from` varchar(10) NOT NULL,
  `blocked_to` varchar(10) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id_image` bigint(20) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `code_vehicule` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `info_sbc`
--

CREATE TABLE `info_sbc` (
  `idinfo_sbc` int(11) NOT NULL,
  `adresse` varchar(1000) DEFAULT NULL,
  `mail_sbc` varchar(45) DEFAULT NULL,
  `modified` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id_location` bigint(20) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `motif` varchar(500) DEFAULT NULL,
  `code_client` varchar(20) DEFAULT NULL,
  `etat_location` enum('-1','0','1') DEFAULT '0' COMMENT '-1 : annuler\n0: pas de decision\n1 : valider',
  `code_vehicule` varchar(10) DEFAULT NULL,
  `personnel` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

CREATE TABLE `marque` (
  `id_marque` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `nous_ecrire`
--

CREATE TABLE `nous_ecrire` (
  `date` datetime NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `motif` varchar(2500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `page`
--

CREATE TABLE `page` (
  `id_page` int(11) NOT NULL,
  `page_name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `detail` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` bigint(20) NOT NULL,
  `unique_id` varchar(20) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `etat_compte` enum('-1','1') DEFAULT '1' COMMENT '-1:desactive\n1 :activer\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `unique_id`, `prenom`, `nom`, `adresse`, `telephone`, `email`, `username`, `password`, `etat_compte`) VALUES
(1, '201607YY', 'ibrahima', 'diop', 'darou', '784563765', 'diop.ib@gmail.com', 'khaliljoop', 'khalil', '-1'),
(2, '201805ST', 'Admin', 'Admin', 'dd', '786589076', 'admin@admin.com', 'administrator', '$2y$10$yfi5nUQGXUZtMdl27dWAyOd/jMOmATBpiUvJDmUu9hJ5Ro6BE5wsK', '1');

-- --------------------------------------------------------

--
-- Structure de la table `sys_menu`
--

CREATE TABLE `sys_menu` (
  `id_menu` int(11) NOT NULL,
  `code` varchar(100) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `etat` enum('-1','1') DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sys_menu`
--

INSERT INTO `sys_menu` (`id_menu`, `code`, `libelle`, `etat`) VALUES
(1, 'DASH', 'DASHBOARD', '1'),
(2, 'SECURITE', 'SECURITE', '1'),
(3, 'LST_PERS', 'Liste personnel', '1');

-- --------------------------------------------------------

--
-- Structure de la table `sys_sous_menu`
--

CREATE TABLE `sys_sous_menu` (
  `id_sous_menu` int(11) NOT NULL,
  `id_menu` int(11) DEFAULT NULL,
  `code` varchar(100) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `etat` enum('-1','1') DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sys_sous_menu`
--

INSERT INTO `sys_sous_menu` (`id_sous_menu`, `id_menu`, `code`, `libelle`, `etat`) VALUES
(1, 1, 'DASH', 'Dashboard', '1'),
(3, 2, 'MENU', 'Menu', '1'),
(4, 2, 'PROFIL', 'Profil', '1'),
(5, 2, 'USR', 'Utilisateurs', '1'),
(6, 2, 'LST_MENU', 'Liste menu', '1'),
(7, 2, 'LST_S_MENU', 'Liste sous menu', '1'),
(12, 3, 'PERSONNEL', 'Personnel', '1');

-- --------------------------------------------------------

--
-- Structure de la table `sys_type_action`
--

CREATE TABLE `sys_type_action` (
  `id_actions` int(11) NOT NULL,
  `id_type_profil` int(11) DEFAULT NULL,
  `id_sous_menu` int(11) DEFAULT NULL,
  `d_read` enum('-1','1') DEFAULT '1',
  `d_add` enum('-1','1') DEFAULT '1',
  `d_upd` enum('-1','1') DEFAULT '1',
  `d_del` enum('-1','1') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sys_type_action`
--

INSERT INTO `sys_type_action` (`id_actions`, `id_type_profil`, `id_sous_menu`, `d_read`, `d_add`, `d_upd`, `d_del`) VALUES
(1, 1, 1, '1', '1', '1', '1'),
(2, 1, 3, '1', '1', '1', '1'),
(3, 1, 4, '1', '1', '1', '1'),
(4, 1, 5, '1', '1', '1', '1'),
(5, 1, 6, '1', '1', '1', '1'),
(6, 1, 7, '1', '1', '1', '1'),
(16, 1, 12, '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Structure de la table `sys_type_profil`
--

CREATE TABLE `sys_type_profil` (
  `id_type_profil` int(11) NOT NULL,
  `libelle_type_profil` varchar(250) DEFAULT NULL,
  `etat` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sys_type_profil`
--

INSERT INTO `sys_type_profil` (`id_type_profil`, `libelle_type_profil`, `etat`) VALUES
(1, 'ADMIN', '1'),
(2, 'FOURNISSEUR', '1'),
(3, 'CLIENT', '1'),
(4, 'ASSISTANTE', '1');

-- --------------------------------------------------------

--
-- Structure de la table `sys_user`
--

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `unique_id` varchar(8) DEFAULT NULL,
  `id_profil` int(11) DEFAULT NULL,
  `statut` enum('0','1') DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sys_user`
--

INSERT INTO `sys_user` (`id`, `unique_id`, `id_profil`, `statut`) VALUES
(1, '201607YY', 1, '1'),
(2, '201805ST', 1, '1');

-- --------------------------------------------------------

--
-- Structure de la table `type_activite`
--

CREATE TABLE `type_activite` (
  `id_type_activite` int(11) NOT NULL,
  `libelle` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user_messages`
--

CREATE TABLE `user_messages` (
  `time` datetime(6) NOT NULL,
  `sender_message_id` varchar(20) NOT NULL,
  `receiver_message_id` varchar(20) NOT NULL,
  `message` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id_vehicule` int(11) NOT NULL,
  `matricule` varchar(45) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `type_carburant` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `stat_vehicule` enum('vente','location','pub') DEFAULT 'pub',
  `code_vehicule` varchar(10) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `marque` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `id_vente` bigint(20) NOT NULL,
  `etat` enum('-1','0','1') DEFAULT '0' COMMENT '-1:annuler\n0 : pas de decision\n1: valider',
  `code_client` varchar(10) DEFAULT NULL,
  `code_vehicule` varchar(10) DEFAULT NULL,
  `decision` datetime DEFAULT NULL,
  `code_personnel` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activite`
--
ALTER TABLE `activite`
  ADD PRIMARY KEY (`id_activite`),
  ADD UNIQUE KEY `libelle_UNIQUE` (`type_activite`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id_image`),
  ADD KEY `fk_code_v` (`code_vehicule`);

--
-- Index pour la table `info_sbc`
--
ALTER TABLE `info_sbc`
  ADD PRIMARY KEY (`idinfo_sbc`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id_location`),
  ADD KEY `fk_code_client_idx` (`code_client`),
  ADD KEY `fk_code_vehicule_idx` (`code_vehicule`);

--
-- Index pour la table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`id_marque`),
  ADD UNIQUE KEY `libelle_UNIQUE` (`libelle`);

--
-- Index pour la table `nous_ecrire`
--
ALTER TABLE `nous_ecrire`
  ADD PRIMARY KEY (`date`);

--
-- Index pour la table `page`
--
ALTER TABLE `page`
  ADD PRIMARY KEY (`id_page`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`),
  ADD UNIQUE KEY `unique_id_UNIQUE` (`unique_id`),
  ADD UNIQUE KEY `emaill_UNIQUE` (`email`);

--
-- Index pour la table `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Index pour la table `sys_sous_menu`
--
ALTER TABLE `sys_sous_menu`
  ADD PRIMARY KEY (`id_sous_menu`);

--
-- Index pour la table `sys_type_action`
--
ALTER TABLE `sys_type_action`
  ADD PRIMARY KEY (`id_actions`);

--
-- Index pour la table `sys_type_profil`
--
ALTER TABLE `sys_type_profil`
  ADD PRIMARY KEY (`id_type_profil`);

--
-- Index pour la table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id_UNIQUE` (`unique_id`);

--
-- Index pour la table `type_activite`
--
ALTER TABLE `type_activite`
  ADD PRIMARY KEY (`id_type_activite`),
  ADD UNIQUE KEY `libelle_UNIQUE` (`libelle`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id_vehicule`),
  ADD UNIQUE KEY `matricule_UNIQUE` (`matricule`),
  ADD UNIQUE KEY `code_vehicule_UNIQUE` (`code_vehicule`),
  ADD KEY `fk_marque_idx` (`marque`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `info_sbc`
--
ALTER TABLE `info_sbc`
  MODIFY `idinfo_sbc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id_location` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `marque`
--
ALTER TABLE `marque`
  MODIFY `id_marque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `page`
--
ALTER TABLE `page`
  MODIFY `id_page` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id_personne` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `sys_menu`
--
ALTER TABLE `sys_menu`
  MODIFY `id_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `sys_sous_menu`
--
ALTER TABLE `sys_sous_menu`
  MODIFY `id_sous_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `sys_type_action`
--
ALTER TABLE `sys_type_action`
  MODIFY `id_actions` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `sys_type_profil`
--
ALTER TABLE `sys_type_profil`
  MODIFY `id_type_profil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `sys_user`
--
ALTER TABLE `sys_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id_vehicule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activite`
--
ALTER TABLE `activite`
  ADD CONSTRAINT `fk_activite` FOREIGN KEY (`type_activite`) REFERENCES `type_activite` (`id_type_activite`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `fk_code_v` FOREIGN KEY (`code_vehicule`) REFERENCES `vehicule` (`code_vehicule`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `fk_code_client` FOREIGN KEY (`code_client`) REFERENCES `personne` (`unique_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_code_vehicule` FOREIGN KEY (`code_vehicule`) REFERENCES `vehicule` (`code_vehicule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `fk_marque` FOREIGN KEY (`marque`) REFERENCES `marque` (`id_marque`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
