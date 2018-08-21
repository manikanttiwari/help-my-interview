# help-my-interview

## Author  
         Mani Kant Tiwari
		 
## contributor  
	
	
      1. Anubhav Srivastava
	  2. Sumit Mishra
	  3. Mani Kant Tiwari

		 
## my email
        manikanttiwari8@gmail.com
		
## script for the database  

```
DROP SCHEMA IF EXISTS `help-my-interview`;

create schema `help-my-interview`;
use `help-my-interview`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `applicant`;

create table `applicant_skills`(
	`id` int(3) not null auto_increment,
    `skill1` varchar(20)  DEFAULT NULL,
    `skill2` varchar(20)  DEFAULT NULL,
    `skill3` varchar(20)  DEFAULT NULL,
    `skill4` varchar(20)  DEFAULT NULL,
    `skill5` varchar(20)  DEFAULT NULL,
    `skill6` varchar(20)  DEFAULT NULL,
    `skill7` varchar(20)  DEFAULT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `applicant_detail` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) DEFAULT NULL,
    `age` int(2) DEFAULT NULL,	
    `college_name` varchar(20) DEFAULT NULL,
    `applicant_skills_id` int(3) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`applicant_skills_id`)
    REFERENCES `applicant_skills` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `applicant` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
    `userid` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    `applicant_detail_id` int(3) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_DETAIL1` FOREIGN KEY (`applicant_detail_id`)
    REFERENCES `applicant_detail` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `company`;

create table `company_required_skills` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`skill1` varchar(20)  DEFAULT NULL,
    `skill2` varchar(20)  DEFAULT NULL,
    `skill3` varchar(20)  DEFAULT NULL,
    `skill4` varchar(20)  DEFAULT NULL,
    `skill5` varchar(20)  DEFAULT NULL,
    `skill6` varchar(20)  DEFAULT NULL,
    `skill7` varchar(20)  DEFAULT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `company_detail` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
    `cname` varchar(20) DEFAULT NULL,
    `company_tenure` int(3) DEFAULT NULL,
    `jobs` varchar(20) DEFAULT NULL,
    `company_required_skills_id` int(3) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_DETAIL3` FOREIGN KEY (`company_required_skills_id`)
    REFERENCES `company_required_skills` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `company` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
    `userid` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    `company_detail_id` int(3) DEFAULT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `FK_DETAIL4` FOREIGN KEY (`company_detail_id`)
    REFERENCES `company_detail` (`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `applied_applicant` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`company_id` int(3) DEFAULT NULL,
    `applicant_id` varchar(20) DEFAULT NULL, 
    PRIMARY KEY(`id`),
    CONSTRAINT `FK_DETAIL5` FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
```

