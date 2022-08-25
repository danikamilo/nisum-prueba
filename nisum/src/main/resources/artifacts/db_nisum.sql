-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-08-2022 a las 01:12:03
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_nisum`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_users`
--

CREATE TABLE `tb_users` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phones` varchar(400) DEFAULT NULL,
  `created` date NOT NULL,
  `modified` date NOT NULL,
  `last_login` date NOT NULL,
  `token` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `isactive` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_users`
--

INSERT INTO `tb_users` (`id_user`, `name`, `email`, `password`, `phones`, `created`, `modified`, `last_login`, `token`, `isactive`) VALUES
(4, 'Pedro Rodriguez', 'juan@pedro.org', 'Ahunter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', 'b28a42fd-2431-4e1b-82ca-d61a7fdfcd13', 1),
(5, 'Juana Rodriguez', 'juan@juan.org', 'Ahunter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', '48ab36cf-5a0f-4c35-9b7d-c2ecd59c7eb0', 1),
(6, 'Enrique Luis', 'enrique@enrique.org', 'Ahunter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', '4c75831a-8abd-4fcf-9055-8af3da6b5869', 1),
(7, 'Laura Camilo', 'laura@camiloenrique.com', 'Ahunter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', 'f8c2e51b-99d3-41ea-baca-7dcf03f01d5d', 1),
(8, 'Daniel Camilo', 'danikamilo777@gmail.com', 'huAnter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', 'adb8c0aa-b665-4558-bb97-5f6c5b0d4e3e', 1),
(9, 'Juanito Contreras', 'juanitoContreras@gmail.com', 'huAnter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', 'f86152d6-1844-4b7e-87bd-48109127ba6e', 1),
(10, 'Laura Camilo', 'laura@camiloenriquae.com', 'Ahunter2', '[{\"number\":\"1234567\",\"citycode\":\"1\",\"contrycode\":\"57\"}]', '2022-08-25', '2022-08-25', '2022-08-25', 'dc75287c-6270-4281-83c1-e8ed8758f748', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_users`
--
ALTER TABLE `tb_users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_users`
--
ALTER TABLE `tb_users`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
