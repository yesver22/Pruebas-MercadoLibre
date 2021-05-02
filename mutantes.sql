-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2021 a las 21:35:59
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mutantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stats`
--

CREATE TABLE `stats` (
  `id` int(11) NOT NULL,
  `cadena` varchar(500) NOT NULL,
  `resultado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `stats`
--

INSERT INTO `stats` (`id`, `cadena`, `resultado`) VALUES
(1, '[Ljava.lang.String;@259a7d83', 'Mutante'),
(2, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTATCACTG', 'Mutante'),
(3, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano'),
(4, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano'),
(5, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano'),
(6, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano'),
(7, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano'),
(8, 'ATGCGYCAGTGYTTATGYAGAAGYCCCCTYTCACTG', 'Humano');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `stats`
--
ALTER TABLE `stats`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `stats`
--
ALTER TABLE `stats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
