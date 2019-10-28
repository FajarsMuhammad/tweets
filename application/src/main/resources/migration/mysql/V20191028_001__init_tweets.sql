/* Copyright (C) 2019 ASYX International B.V. All rights reserved. */
CREATE TABLE `tweets` (
  `uuid` varchar(255) NOT NULL,
  `user` varchar(255)  DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;