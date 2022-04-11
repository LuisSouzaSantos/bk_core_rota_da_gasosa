use rotadagasosa;

create table `available_time`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    UNIQUE(name),
    PRIMARY KEY (id)
);

create table `flag`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    UNIQUE(name),
    PRIMARY KEY (id)
);

create table `fuel`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    UNIQUE(name),
    PRIMARY KEY (id)
);

create table `promotion`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    UNIQUE(name),
    PRIMARY KEY (id)
);

create table `service`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    UNIQUE(name),
    PRIMARY KEY (id)
);

create table `gas_station`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `flag_id` BIGINT(20) NOT NULL,
    `cnpj` VARCHAR(14) NOT NULL,
    `cep` VARCHAR(8) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
	`address_number` VARCHAR(255) NOT NULL,
	`latitude` DECIMAL(5,5) NOT NULL,
    `longitude` DECIMAL(5,5) NOT NULL,
    `active` BIT(1) NOT NULL,
    `verified` BIT(1) NOT NULL,
    `deleted`  BIT(1) NOT NULL,
    UNIQUE(name),
    UNIQUE(cnpj),
	PRIMARY KEY (id)
);

create table `customer` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `cpf` VARCHAR(11) NOT NULL,
    `cep` VARCHAR(8) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
	`address_number` VARCHAR(255) NOT NULL,
    `address_complement` VARCHAR(255) NOT NULL,
	`active` BIT(1) NOT NULL,
    `deleted`  BIT(1) NOT NULL,
    PRIMARY KEY (id)
);

create table `available_time_details`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `day_of_week` VARCHAR(9) NOT NULL,
    `start_time` DATETIME NOT NULL,
    `end_time` DATETIME NOT NULL,
    `available_time_id` BIGINT(20) NOT NULL,
    `gas_station_id` BIGINT(20) NOT NULL,
    CONSTRAINT FK_AvailableTimeDetails_AvailableTime FOREIGN KEY (available_time_id) REFERENCES `available_time` (id),
    CONSTRAINT FK_AvailableTimeDetails_GasStation FOREIGN KEY (gas_station_id) REFERENCES `gas_station` (id),
    PRIMARY KEY (id)
);

create table `fuel_details`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `price` DECIMAL(3,3) NOT NULL,
    `available` BIT(1) NOT NULL,
    `fuel_id` BIGINT(20) NOT NULL,
    `gas_station_id` BIGINT(20) NOT NULL,
    CONSTRAINT FK_FuelDetails_Fuel FOREIGN KEY (fuel_id) REFERENCES `fuel` (id),
    CONSTRAINT FK_FuelDetails_GasStation FOREIGN KEY (gas_station_id) REFERENCES `gas_station` (id),
    PRIMARY KEY (id)
);

create table `promotion_details`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `start_time` DATETIME NOT NULL,
    `end_time` DATETIME NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `promotion_id` BIGINT(20) NOT NULL,
    `gas_station_id` BIGINT(20) NOT NULL,
    CONSTRAINT FK_PromotionDetails_Promotion FOREIGN KEY (promotion_id) REFERENCES `promotion` (id),
    CONSTRAINT FK_PromotionDetails_GasStation FOREIGN KEY (gas_station_id) REFERENCES `gas_station` (id),
    PRIMARY KEY (id)
);

create table `service_details`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `start_time` DATETIME NOT NULL,
    `end_time` DATETIME NOT NULL,
    `occurrence` BIT(1) NOT NULL,
    `day_of_week` VARCHAR(9) NOT NULL,
    `available` BIT(1) NOT NULL,
    `service_id` BIGINT(20) NOT NULL,
    `gas_station_id` BIGINT(20) NOT NULL,
	CONSTRAINT FK_ServiceDetails_Service FOREIGN KEY (service_id) REFERENCES `service` (id),
    CONSTRAINT FK_ServiceDetails_GasStation FOREIGN KEY (gas_station_id) REFERENCES `gas_station` (id),
	PRIMARY KEY (id)
);

create table `vehicle_details`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `model` VARCHAR(255) NOT NULL,
    `brand` VARCHAR(255) NOT NULL,
    `fuel_id` BIGINT(20) NOT NULL,
    `customer_id` BIGINT(20) NOT NULL,
    CONSTRAINT FK_VehicleDetails_Fuel FOREIGN KEY (fuel_id) REFERENCES `fuel` (id),
    CONSTRAINT FK_VehicleDetails_Customer FOREIGN KEY (customer_id) REFERENCES `customer` (id),
    PRIMARY KEY (id)
);

create table `used_gas_station`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `fuel_amount` DECIMAL(5,3) NOT NULL,
    `liter_price` DECIMAL(3,3) NOT NULL,
    `date` DATETIME NOT NULL,
    `gas_station_id` BIGINT(20) NOT NULL,
    `customer_id` BIGINT(20) NOT NULL,
    CONSTRAINT FK_UsedGasStation_GasStation FOREIGN KEY (gas_station_id) REFERENCES `gas_station` (id),
    CONSTRAINT FK_UsedGasStation_Customer FOREIGN KEY (customer_id) REFERENCES `customer` (id),
	PRIMARY KEY (id)
);