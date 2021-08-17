Create Database ICDS
Use ICDS

Create table Punetori(
P_ID int not null,
Emri varchar(20) not null,
Mbiemri varchar(20) not null,
Mosha int not null,
Gjinia char not null,
Pozita int not null,
Adresa varchar(50) not null,
Punetori_LogIn int ,
 constraint P_pk PRIMARY KEY (P_ID),
 constraint P_fk foreign key (Pozita) references Pozitat(Pozita_ID),
 constraint P1_fk foreign key (Punetori_LogIn) references Users(U_ID)
 )
 Insert into Punetori values (1,'Filan','Fisteku',30,'M',1,'Rr.Adem Jashari',1)
  Insert into Punetori values (2,'Punetor','Mbiemri',34,'M',2,'Rr.Adem Jashari',2)
    Insert into Punetori values (3,'Punetori1','Mbiemri1',45,'M',3,'Rr.Adem Jashari',null)



create Table Pozitat(
Pozita_ID int not null,
Emri varchar(20) not null,
constraint Poz_pk primary key (Pozita_ID)
)

Create Table Users(
U_ID int not null,
U_IDLOG varchar(50) not null,
U_Password varchar(50) not null
constraint U_pk primary key (U_ID),
)
Insert into Users values(1,'menaxher','menaxher')
Insert into Users values(2,'punetor','punetor')
Insert into Users values(3,'klienti','klienti')






create Table Klienti(
K_ID int not null,
Emri varchar(20) not null,
Mbiemri varchar(20) not null,
Mosha int not null,
Gjinia char not null,
Qyteti int not null,
Klienti_LogIn int not null,
constraint K_pk primary key (K_ID),
constraint K_fk FOREIGN KEY (Qyteti) references Qyteti(Qyteti_ID),
 constraint K1_fk foreign key (Klienti_LogIn) references Users(U_ID),
)

Insert into Klienti values (1,'Klienti1','Mbiemri1',40,'M',1,3)
Insert into Klienti values (2,'Klienti2','Mbiemri2',32,'M',2,4)
Insert into Klienti values (3,'Klienti3','Mbiemri3',25,'M',3,5)

create Table Biznesi(
Biznesi_ID int not null,
Emri varchar(40) not null,
Lloji int not null,
Qyteti int not null,
Komuna int not null,
constraint B_pk primary key (Biznesi_ID),
constraint B_fk foreign key (Lloji) references Lloji_i_Biznesit(LL_ID),
constraint B2_fk FOREIGN KEY (Qyteti) references Qyteti(Qyteti_ID),
constraint B3_fk foreign key (Komuna) references Komuna(K_ID)
)

create Table Lloji_i_Biznesit(
LL_ID int not null,
Emri varchar(20) not null,
constraint LL_pk primary key (LL_ID)
)
Insert into Lloji_i_Biznesit values (1,'NTP')
Insert into Lloji_i_Biznesit values (2,'SHPK')
Insert into Lloji_i_Biznesit values (3,'SHA')

create Table Qyteti(
	Qyteti_ID int not null,
	Emri varchar(20) not null,
	Zip_Code int not null,
	constraint Q_pk primary key(Qyteti_ID)
)

Insert into Qyteti values(1,'Prishtina',10000)
Insert into Qyteti values(2,'Prizren',20000)
Insert into Qyteti values(3,'Ferizaj',30000)
Insert into Qyteti values(4,'Peje',40000)
Insert into Qyteti values(5,'Gjakove',50000)
Insert into Qyteti values(6,'Mitrovice',60000)
Insert into Qyteti values(7,'Gjilan',70000)
Insert into Qyteti values(8,'Podujeve',80000)
Insert into Qyteti values(9,'Vushtrri',90000)
Insert into Qyteti values(10,'Suhareke',100000)
Insert into Qyteti values(11,'Skenderaj',11000)
Insert into Qyteti values(12,'Rahovec',10000)
Insert into Qyteti values(13,'Lipjan',10000)
Insert into Qyteti values(14,'Malisheve',10000)
Insert into Qyteti values(15,'Kamenice',10000)
Insert into Qyteti values(16,'Viti',10000)
Insert into Qyteti values(17,'Deqan',10000)

create Table Komuna(
K_ID int not null,
Emri varchar(50) not null,
Qyteti int not null,
constraint Kom_pk primary key (K_ID),
constraint Kom_fk foreign key (Qyteti) references Qyteti(Qyteti_ID)
)


Insert into Komuna values(1,'Prishtine',1)
Insert into Komuna values(2,'Prizren',2)
Insert into Komuna values(3,'Ferizaj',3)
Insert into Komuna values(4,'Peje',4)
Insert into Komuna values(5,'Gjakove',5)
Insert into Komuna values(6,'Mitrovice e Jugut',6)
Insert into Komuna values(7,'Mitrovice e Veriut',6)
Insert into Komuna values(8,'Gjilan',7)
Insert into Komuna values(9,'Ranilluk',7)
Insert into Komuna values(10,'Podujeve',8)
Insert into Komuna values(11,'Vushtrri',9)
Insert into Komuna values(12,'Suhareke',10)
Insert into Komuna values(13,'Skenderaj',11)
Insert into Komuna values(14,'Drenas',11)
Insert into Komuna values(15,'Rahovec',12)
Insert into Komuna values(16,'Lipjan',13)
Insert into Komuna values(17,'Malisheve',14)
Insert into Komuna values(18,'Kamenice',15)
Insert into Komuna values(19,'Viti',16)
Insert into Komuna values(20,'Deqan',17)
Insert into Komuna values(21,'Junik',5)
Insert into Komuna values(22,'Mamushe',2)
Insert into Komuna values(23,'Graqanice',1)
Insert into Komuna values(24,'Kllokot',7)


create Table Produkti(
Produkti_ID int not null unique,
Emri varchar(70) not null,
Cmimi decimal(5,2) not null,
Barkodi int not null,
Palete decimal(5,1) not null ,
Paketa decimal(5,1) not null,
Cope decimal (5,1) not null,
constraint Pr_pk primary key (Produkti_ID)
)


Insert into Produkti values(1,'Rumenko ',12,1234567890,1,100,36)
Insert into Produkti values(2,'Duo ',12,1234567891,1,94,48)
Insert into Produkti values(3,'Bumm shkop Çok ',18,1234567892,1,96,36)
Insert into Produkti values(4,'Bumm  shkop dredheza ',18,1234567893,1,96,36)
Insert into Produkti values(5,'Bumm  shkop vanilija ',18,1234567894,1,96,36)
Insert into Produkti values(6,'Bumm  shkop banana ',18,1234567895,1,96,36)
Insert into Produkti values(7,'Snjeguljica ',20,1234567896,1,112,36)
Insert into Produkti values(8,'Roller ',17,1234567897,1,110,20)
Insert into Produkti values(9,'Capri  ',27,1234567898,1,90,36)
Insert into Produkti values(10,'Macho qokollata ',24,1234567899,1,112,36)
Insert into Produkti values(11,'Macho jaffa ',24,1234567900,1,106,36)
Insert into Produkti values(12,'Lollipop',15,1234567901,1,85,42)
Insert into Produkti values(13,'Kornet vanilija ',25,1234567902,1,76,24)
Insert into Produkti values(14,'Kornet  çokolada ',25,1234567903,1,76,24)
Insert into Produkti values(15,'Kornet  fruta pyllit ',25,1234567904,1,76,24)
Insert into Produkti values(16,'Kornet Milka vishnje ',25,1234567905,1,76,24)
Insert into Produkti values(17,'Maximo Browin ',30,1234567906,1,34,24)
Insert into Produkti values(18,'King Classic ',35,1234567907,1,102,20)
Insert into Produkti values(19,'King Perfection ',35,1234567908,1,102,20)
Insert into Produkti values(20,'King Love ',35,1234567909,1,102,20)
Insert into Produkti values(21,'King Caramel Adventure ',35,1234567910,1,102,20)
Insert into Produkti values(22,'King Double ',35,1234567911,1,102,20)
Insert into Produkti values(23,'King Extra Panna Cotta Malina  ',35,1234567912,1,102,20)
Insert into Produkti values(24,'King Chocolate Obsession ',35,1234567913,1,102,20)
Insert into Produkti values(25,'Bumm gota vanilija sa çok ',19,1234567914,1,108,24)
Insert into Produkti values(26,'Bumm gota van dredheza ',19,1234567915,1,108,24)
Insert into Produkti values(27,'Gran stracc.-frutat pyllit ',12,1234567916,1,40,4)
Insert into Produkti values(28,'Grandissimo Milka ',26,1234567917,1,40,4)
Insert into Produkti values(29,'Grandissimo Schwarzwald ',26,1234567918,1,40,4)
Insert into Produkti values(30,'Mini Quattro Classic ',40,1234567919,1,36,4)
Insert into Produkti values(31,'Mini Quattro Orijent ',40,1234567920,1,36,4)
Insert into Produkti values(32,'Mini Quattro Banana Split ',40,1234567921,1,36,4)
Insert into Produkti values(33,'Mini Quattro Chocomania ',40,1234567922,1,36,4)
Insert into Produkti values(34,'Mini Quattro Jaffa ',40,1234567923,1,36,4)
Insert into Produkti values(35,'Twice 1L vanilija-çokolada ',25,1234567924,1,64,6)
Insert into Produkti values(36,'Twice 1L vanilija- dredheza ',25,1234567925,1,64,6)
Insert into Produkti values(37,'Twice 1 L vanilija-lajthi ',25,1234567926,1,64,6)




create Table Stoku(
Stoku_ID int ,
Produkti_ID int not null,
Palete decimal(12,1) not null ,
Paketa decimal(12,1) not null,
Cope decimal (12,1) not null,
DataSkadencesProd datetime,
constraint Stoku_fk foreign key (Produkti_ID) references Produkti(Produkti_ID),
constraint Stoku_pk primary key (Stoku_ID),
)

Insert into Stoku values(1,1,0,0,0,'2019.04.13')
Insert into Stoku values(2,2,0,0,0,'2019.04.13')
Insert into Stoku values(3,3,0,0,0,'2019.04.13')
Insert into Stoku values(4,4,0,0,0,'2019.04.13')
Insert into Stoku values(5,5,0,0,0,'2019.04.13')
Insert into Stoku values(6,6,0,0,0,'2019.04.13')
Insert into Stoku values(7,7,0,0,0,'2019.04.13')
Insert into Stoku values(8,8,0,0,0,'2019.04.13')
Insert into Stoku values(9,9,0,0,0,'2019.04.13')
Insert into Stoku values(10,10,0,0,0,'2019.04.13')
Insert into Stoku values(11,11,0,0,0,'2019.04.13')
Insert into Stoku values(12,12,0,0,0,'2019.04.13')
Insert into Stoku values(13,13,0,0,0,'2019.04.13')
Insert into Stoku values(14,14,0,0,0,'2019.04.13')
Insert into Stoku values(15,15,0,0,0,'2019.04.13')
Insert into Stoku values(16,16,0,0,0,'2019.04.13')
Insert into Stoku values(17,17,0,0,0,'2019.04.13')
Insert into Stoku values(18,18,0,0,0,'2019.04.13')
Insert into Stoku values(19,19,0,0,0,'2019.04.13')
Insert into Stoku values(20,20,0,0,0,'2019.04.13')
Insert into Stoku values(21,21,0,0,0,'2019.04.13')
Insert into Stoku values(22,22,0,0,0,'2019.04.13')
Insert into Stoku values(23,23,0,0,0,'2019.04.13')
Insert into Stoku values(24,24,0,0,0,'2019.04.13')
Insert into Stoku values(25,25,0,0,0,'2019.04.13')
Insert into Stoku values(26,26,0,0,0,'2019.04.13')
Insert into Stoku values(27,27,0,0,0,'2019.04.13')
Insert into Stoku values(28,28,0,0,0,'2019.04.13')
Insert into Stoku values(29,29,0,0,0,'2019.04.13')
Insert into Stoku values(30,30,0,0,0,'2019.04.13')
Insert into Stoku values(31,31,0,0,0,'2019.04.13')
Insert into Stoku values(32,32,0,0,0,'2019.04.13')
Insert into Stoku values(33,33,0,0,0,'2019.04.13')
Insert into Stoku values(34,34,0,0,0,'2019.04.13')
Insert into Stoku values(35,35,0,0,0,'2019.04.13')
Insert into Stoku values(36,36,0,0,0,'2019.04.13')
Insert into Stoku values(37,37,0,0,0,'2019.04.13')

create Table Porosia(
Porosia_ID int not null,
Produkti_ID int not null,
Sasia int not null,
Biznesi_ID int not null,
Adresa varchar(60) not null,
Totali decimal(12,1) not null,
constraint Porosia_pk primary key (Porosia_ID),
constraint Porosia_fk foreign key (Produkti_ID) references Produkti(Produkti_ID),
constraint Porosia2_fk foreign key (Biznesi_ID) references Biznesi(Biznesi_ID),
)

create Table Porosite(
PorositeId int not null,
Biznesi_ID int not null,
Data datetime not null,
Sasia int not null,
Totali decimal(12,1)  not null,
constraint porosite_pk primary key(PorositeId),
constraint porosite_fk foreign key(Biznesi_ID ) references Biznesi(Biznesi_ID),
)





create Table Faktura(
Faktura_ID int not null,
Biznesi_ID int not null,
Produkti_ID int not null,
Cmimi_me_TVSH decimal(5,2) not null,
Cmimi decimal(5,2) not null ,
Data datetime,
Barkodi int not null,
Sasia decimal(12,1) not null,
constraint Faktura_pk primary key (Faktura_ID),
constraint Faktura_fk foreign key(Biznesi_ID) references Biznesi(Biznesi_ID),
constraint Faktura2_fk foreign key(Produkti_ID) references Produkti(Produkti_ID),
)



create Table FaturaHyrese(
FaturaH_ID int not null,
Produkti_ID int not null,
Cmimi decimal(12,1) not null,
Data datetime,
Palete decimal(12,1) not null ,
Paketa decimal(12,1) not null,
Cope decimal (12,1) not null,
Data_e_Skadences datetime not null,
constraint FaturaH_pk primary key (FaturaH_ID),
constraint Fatura_fk foreign key(Produkti_ID) references Produkti(Produkti_ID),
)






create Table Shitjet(
Shitjet_ID int not null,
Biznesi_ID int not null,
Data datetime not null,
Cmimi_me_Tvsh decimal(12,1) not null,
Cmimi_pa_Tvsh decimal(12,1) not null,
Totali decimal (12,1) not null,
SasiaPaket decimal(12,1) not null,
constraint sh_pk primary key(Shitjet_ID),
constraint sh_fk foreign key(Biznesi_ID) references  Biznesi(Biznesi_ID),
)

create Table Hyrjet(
Hyrjet_ID int not null,
Totali decimal(12,1) not null,
Data Datetime not null,
Palete decimal(12,1) not null ,
Paketa decimal(12,1) not null,
Cope decimal (12,1) not null,
constraint h_pk primary key (Hyrjet_ID),
)


