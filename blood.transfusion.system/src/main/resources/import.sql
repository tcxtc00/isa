
INSERT INTO public.authority(name) VALUES ('ROLE_REGISTEREDUSER');
INSERT INTO public.authority(name) VALUES ('ROLE_STAFF');


INSERT INTO public.blood_transfusion_center(address, city, description, name, rate) VALUES ('Futoska 2', 'Novi Sad', 'Misija instituta za transfuziju krvi je da realizuje aktivnosti na omasovljenju davalaštva krvi. Promoviše dobrovoljno, anonimno i nenagrađeno davalaštvo krvi.', 'Institut za transfuziju krvi Vojvodina', 5);
INSERT INTO public.blood_transfusion_center(address, city, description, name, rate) VALUES ('Svetosavska 10', 'Beograd', 'Vizija instituta za transfuziju krvi je da bude vodeća, visoko specijalizovana, naučno istraživačka i nastavna zdravstvena ustanova, referalna za oblast transfuziologije u Srbiji, u kojoj se delatnosti odvijaju u okviru integrisanog sistema menadžmenta.', 'Institut za transfuziju krvi Beograd', 4);
INSERT INTO public.blood_transfusion_center(address, city, description, name, rate) VALUES ('Petra Kocica 2', 'Subotica', 'Pre 60 godine formirana je služba za transfuziju krvi u Subotici koja je na svom razvojnom putu prošla kroz više faza, od kojih je svaka ostavila tragove na njenu sadašnju fizionomiju.', 'Institut za transfuziju krvi Subotica', 5);
INSERT INTO public.blood_transfusion_center(address, city, description, name, rate) VALUES ('Petra Kocica 2', 'Kragujevac', 'Zavod intenzivno radi na omasovljavanju dobrovoljnog davalaštva krvi, separiranju krvi, uvođenju novih analiza koje daju sigurnost primene krvi i krvnih derivata.', 'Institut za transfuziju krvi Kragujevac', 4.5);



INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Sterijina 1', 'Novi Sad', 'Srbija', 1, '1012999123456', 'Ana', '123', '065431234', 'Administrator centra 1 Vojvodina', 'Institut za transfuziju krvi Vojvodina', 'Bogdanovic', 'isa.tanja.2022+anaA@gmail.com', 1);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Svetosavska 10', 'Beograd', 'Srbija', 0, '1010998123456', 'Luka', '123', '365464563', 'Administrator centra 2 Vojvodina', 'Institut za transfuziju krvi Vojvodina', 'Lukic', 'isa.tanja.2022+lukaA@gmail.com', 1);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Petra Kocica 12', 'Novi Sad', 'Srbija', 1, '0212992123456', 'Adrijana', '123', '0887654412', 'Administrator centra 1 Beograd', 'Institut za transfuziju krvi Beograd', 'Ristic', 'isa.tanja.2022+adrijanaA@gmail.com', 2);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Temerinska 5', 'Kragujevac', 'Srbija', 0, '0112993123456', 'Stefan', '123', '0625623536', 'Administrator centra 2 Beograd', 'Institut za transfuziju krvi Beograd', 'Stefic', 'isa.tanja.2022+stefanA@gmail.com', 2);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Branka Bajica 42', 'Subotica', 'Srbija', 1, '1012981123456', 'Marija', '123', '5345263453', 'Administrator centra 1 Subotica', 'Institut za transfuziju krvi Subotica', 'Veljkovic', 'isa.tanja.2022+marijaA@gmail.com', 3);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Dositejeva 32', 'Subotica', 'Srbija', 0, '1011998123456', 'Kristijan', '123', '53546456', 'Administrator centra 2 Subotica', 'Institut za transfuziju krvi Subotica', 'Markovic', 'isa.tanja.2022+kristijanA@gmail.com', 3);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Dositejeva 50', 'Kragujevac', 'Srbija', 0, '1011989123123', 'Marko', '123', '465463544', 'Administrator centra 1 Kragujevac', 'Institut za transfuziju krvi Kragujevac', 'Markovic', 'isa.tanja.2022+markoA@gmail.com', 4);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username, center_id) VALUES ('Staff', 'Petra Kocica 2', 'Kragujevac', 'Srbija', 1, '1009998123654', 'Stefana', '123', '2532456234', 'Administrator centra 2 Subotica', 'Institut za transfuziju krvi Kragujevac', 'Simic', 'isa.tanja.2022+stefanaA@gmail.com', 4);


INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Rumenacka', 'Novi Sad', 'Srbija', 1, '1012999123111', 'Tanja', '123', '3564536436', 'Medicinska sestra 1 Vojvodina', 'Institut za transfuziju krvi Vojvodina', 'Vidic', 'isa.tanja.2022+tanjaM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Ilije Bircanina 11', 'Novi Sad', 'Srbija', 0, '1010998123222', 'Luka', '123', '365464563', 'Medicinska sestra 2 Vojvodina', 'Institut za transfuziju krvi Vojvodina', 'Lazic', 'isa.tanja.2022+lukaM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Nikole Pasica 11', 'Beograd', 'Srbija', 1, '0212992123333', 'Petra', '123', '34345466788', 'Medicinska sestra 1 Beograd', 'Institut za transfuziju krvi Beograd', 'Ristic', 'isa.tanja.2022+petraM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Temerinska 5', 'Beograd', 'Srbija', 0, '2410999123121', 'Lazar', '123', '6346567565', 'Medicinska sestra 2 Beograd', 'Institut za transfuziju krvi Beograd', 'Stefanovic', 'isa.tanja.2022+lazarM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Gunduliceva 22', 'Subotica', 'Srbija', 1, '1012981523221', 'Katarina', '123', '5364564646', 'Medicinska sestra 1 Subotica', 'Institut za transfuziju krvi Subotica', 'Veljic', 'isa.tanja.2022+katarinaM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Jase Tomica 32', 'Subotica', 'Srbija', 0, '1003998123555', 'Nikola', '123', '4674576545', 'Medicinska sestra 2 Subotica', 'Institut za transfuziju krvi Subotica', 'Markovic', 'isa.tanja.2022+nikolaM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Dositejeva 50', 'Kragujevac', 'Srbija', 0, '1012989121113', 'Sanja', '123', '08298467444', 'Medicinska sestra 1 Kragujevac', 'Institut za transfuziju krvi Kragujevac', 'Lukic', 'isa.tanja.2022+sanjaM@gmail.com');
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, surname, username) VALUES ('Staff', 'Svetosavska 2', 'Kragujevac', 'Srbija', 1, '1009998888654', 'Aleksandar', '123', '36436437475', 'Medicinska sestra 2 Subotica', 'Institut za transfuziju krvi Kragujevac', 'Simic', 'isa.tanja.2022+aleksandarM@gmail.com');


INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, status, surname, username, penalties, questionnaire) VALUES ('RegisteredUser', 'Nikole Pasica 55', 'Kraljevo', 'Srbija', 0, '1005995123456', 'Nikola', '$2a$10$C3VgzDUt/I3ghr4yLtF34OnUqAnHZ.OVumf3MWf8Rc7/XmI5ZSmuO', '6467637474', 'Advokat', 'Advokatska komora Srbije', 1, 'Nikovic', 'isa.tanja.2022+nikolaK@gmail.com', 2, false);
INSERT INTO public.users_table(type, address, city, country, gender, jmbg, name, password, phone_number, profession, proffesion_info, status, surname, username, penalties, questionnaire) VALUES ('RegisteredUser', 'Marka Miljanova 11', 'Novi Sad', 'Srbija', 1, '1105994123456', 'Marina', '$2a$10$C3VgzDUt/I3ghr4yLtF34OnUqAnHZ.OVumf3MWf8Rc7/XmI5ZSmuO', '5235235623', 'Profesor matematike', 'Gimnazija Isidora Sekulic, Novi Sad', 1, 'Urosevic', 'isa.tanja.2022+marinaK@gmail.com', 0, false);


INSERT INTO public.user_authority(user_id, authority_id) VALUES (1, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (2, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (3, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (4, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (5, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (6, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (7, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (8, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (9, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (10, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (11, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (12, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (13, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (14, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (15, 2);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (16, 2);

INSERT INTO public.user_authority(user_id, authority_id) VALUES (17, 1);
INSERT INTO public.user_authority(user_id, authority_id) VALUES (18, 1);


INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230106 10:00:00 AM', 35, 0, 1);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230105 10:00:00 AM', 30, 0, 1);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230203 09:00:00 AM', 25, 0, 1);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230110 08:00:00 AM', 30, 0, 2);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230111 09:00:00 AM', 45, 0, 2);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230112 10:00:00 AM', 30, 0, 2);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230209 10:00:00 AM', 25, 0, 3);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230210 10:00:00 AM', 30, 0, 3);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230211 10:00:00 AM', 35, 0, 3);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230102 11:00:00 AM', 30, 0, 4);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230103 08:00:00 AM', 35, 0, 4);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230104 07:00:00 AM', 30, 0, 4);
INSERT INTO public.quick_appointment(date, duration, status, center_id) VALUES ('20230504 07:00:00 AM', 30, 0, 1);


INSERT INTO public.quick_appointment(date, duration, status, center_id, user_id) VALUES ('20230615 07:00:00 AM', 35, 1, 1, 17);

INSERT INTO public.quick_appointment(date, duration, status, center_id, user_id) VALUES ('20210915 07:00:00 AM', 35, 3, 1, 17);
INSERT INTO public.quick_appointment(date, duration, status, center_id, user_id) VALUES ('20220923 08:00:00 AM', 30, 3, 2, 17);
INSERT INTO public.quick_appointment(date, duration, status, center_id, user_id) VALUES ('20221222 08:15:00 PM', 30, 1, 2, 18);


INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (1, 9);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (1, 10);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (2, 9);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (2, 10);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (3, 9);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (4, 11);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (4, 12);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (5, 12);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (5, 11);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (6, 11);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (7, 14);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (7, 13);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (8, 13);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (9, 14);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (10, 15);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (10, 16);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (11, 15);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (11, 16);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (12, 16);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (12, 9);

INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (13, 9);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (14, 9);
INSERT INTO public.appointment_staff(appointment_id, staff_id) VALUES (14, 10);


INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (45, '20230102 11:00:00 AM', 1);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (30, '20221102 11:00:00 AM', 1);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (35, '20230402 11:00:00 AM', 1);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (30, '20221012 10:00:00 AM', 2);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (45, '20230110 10:00:00 AM', 2);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (30, '20230307 10:00:00 AM', 2);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (25, '20230120 09:00:00 AM', 3);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (30, '20221217 09:00:00 AM', 3);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (35, '20230111 08:00:00 AM', 4);
INSERT INTO public.available_appointment(duration, start_date, center_id) VALUES (30, '20230212 08:00:00 AM', 4);