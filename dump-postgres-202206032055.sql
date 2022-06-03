--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-06-03 20:55:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 32845)
-- Name: bank_api; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA bank_api;


ALTER SCHEMA bank_api OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 224 (class 1259 OID 32881)
-- Name: operation_types; Type: TABLE; Schema: bank_api; Owner: postgres
--

CREATE TABLE bank_api.operation_types (
    id smallint NOT NULL,
    name character varying,
    description character varying
);


ALTER TABLE bank_api.operation_types OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 32880)
-- Name: operation_types_id_seq; Type: SEQUENCE; Schema: bank_api; Owner: postgres
--

ALTER TABLE bank_api.operation_types ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME bank_api.operation_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 32866)
-- Name: operations; Type: TABLE; Schema: bank_api; Owner: postgres
--

CREATE TABLE bank_api.operations (
    id integer NOT NULL,
    wallet_id integer NOT NULL,
    type_id smallint NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    amount bigint
);


ALTER TABLE bank_api.operations OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 32865)
-- Name: operations_id_seq; Type: SEQUENCE; Schema: bank_api; Owner: postgres
--

ALTER TABLE bank_api.operations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME bank_api.operations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 32896)
-- Name: wallets; Type: TABLE; Schema: bank_api; Owner: postgres
--

CREATE TABLE bank_api.wallets (
    id integer NOT NULL,
    balance bigint
);


ALTER TABLE bank_api.wallets OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 32895)
-- Name: wallets_id_seq; Type: SEQUENCE; Schema: bank_api; Owner: postgres
--

ALTER TABLE bank_api.wallets ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME bank_api.wallets_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3345 (class 0 OID 32881)
-- Dependencies: 224
-- Data for Name: operation_types; Type: TABLE DATA; Schema: bank_api; Owner: postgres
--

COPY bank_api.operation_types (id, name, description) FROM stdin;
1	putMoney	increase balance
2	takeMoney	decrease balance
4	transferIn	transfer in
3	transferOut	transfer out
\.


--
-- TOC entry 3343 (class 0 OID 32866)
-- Dependencies: 222
-- Data for Name: operations; Type: TABLE DATA; Schema: bank_api; Owner: postgres
--

COPY bank_api.operations (id, wallet_id, type_id, created_at, amount) FROM stdin;
1	1	1	2022-05-21 14:38:05.371374	200
2	1	2	2022-05-21 14:38:17.025699	50
4	1	1	2022-06-01 02:28:57.267497	5000
5	1	2	2022-06-01 02:31:40.266717	1200
3	1	1	2022-06-01 02:27:57.267	5000
6	1	1	2022-06-02 00:35:21.191046	200
7	1	2	2022-06-02 00:35:50.89972	5200
11	1	1	2022-06-02 04:59:32.642	2005
8	1	1	2022-06-02 04:59:32.642	200
9	1	2	2022-06-02 04:59:32.642	5200
10	1	1	2022-06-02 04:59:32.642	200
12	1	1	2022-06-02 05:08:52.21	200
13	1	2	2022-06-02 05:08:52.538	200
14	1	1	2022-06-02 05:09:43.832	200
15	1	2	2022-06-02 05:09:44.141	200
16	1	1	2022-06-03 20:28:29.807	200
17	1	2	2022-06-03 20:28:30.203	200
18	1	3	2022-06-03 20:28:30.579	250
19	2	4	2022-06-03 20:28:30.579	250
20	1	1	2022-06-03 20:32:50.229	200
21	1	2	2022-06-03 20:32:50.611	200
22	1	3	2022-06-03 20:32:50.974	250
23	2	4	2022-06-03 20:32:50.974	250
24	1	3	2022-06-03 20:36:39.244	250
25	2	4	2022-06-03 20:36:39.244	250
26	2	3	2022-06-03 20:41:51.583	250
27	1	4	2022-06-03 20:41:51.583	250
34	1	3	2022-06-03 20:51:09.37	250
35	2	4	2022-06-03 20:51:09.37	250
36	2	3	2022-06-03 20:51:20.462	250
37	1	4	2022-06-03 20:51:20.462	250
38	2	3	2022-06-03 20:51:27.81	2500
39	1	4	2022-06-03 20:51:27.81	2500
40	2	3	2022-06-03 20:51:55.265	250
41	1	4	2022-06-03 20:51:55.265	250
\.


--
-- TOC entry 3347 (class 0 OID 32896)
-- Dependencies: 226
-- Data for Name: wallets; Type: TABLE DATA; Schema: bank_api; Owner: postgres
--

COPY bank_api.wallets (id, balance) FROM stdin;
2	2250
1	12750
\.


--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 223
-- Name: operation_types_id_seq; Type: SEQUENCE SET; Schema: bank_api; Owner: postgres
--

SELECT pg_catalog.setval('bank_api.operation_types_id_seq', 4, true);


--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 221
-- Name: operations_id_seq; Type: SEQUENCE SET; Schema: bank_api; Owner: postgres
--

SELECT pg_catalog.setval('bank_api.operations_id_seq', 41, true);


--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 225
-- Name: wallets_id_seq; Type: SEQUENCE SET; Schema: bank_api; Owner: postgres
--

SELECT pg_catalog.setval('bank_api.wallets_id_seq', 2, true);


--
-- TOC entry 3198 (class 2606 OID 32887)
-- Name: operation_types operation_types_pk; Type: CONSTRAINT; Schema: bank_api; Owner: postgres
--

ALTER TABLE ONLY bank_api.operation_types
    ADD CONSTRAINT operation_types_pk PRIMARY KEY (id);


--
-- TOC entry 3196 (class 2606 OID 32894)
-- Name: operations operations_pk; Type: CONSTRAINT; Schema: bank_api; Owner: postgres
--

ALTER TABLE ONLY bank_api.operations
    ADD CONSTRAINT operations_pk PRIMARY KEY (id);


--
-- TOC entry 3200 (class 2606 OID 32900)
-- Name: wallets wallets_pk; Type: CONSTRAINT; Schema: bank_api; Owner: postgres
--

ALTER TABLE ONLY bank_api.wallets
    ADD CONSTRAINT wallets_pk PRIMARY KEY (id);


--
-- TOC entry 3202 (class 2606 OID 32888)
-- Name: operations operations_type_fk; Type: FK CONSTRAINT; Schema: bank_api; Owner: postgres
--

ALTER TABLE ONLY bank_api.operations
    ADD CONSTRAINT operations_type_fk FOREIGN KEY (type_id) REFERENCES bank_api.operation_types(id);


--
-- TOC entry 3201 (class 2606 OID 32901)
-- Name: operations operations_wallet_fk; Type: FK CONSTRAINT; Schema: bank_api; Owner: postgres
--

ALTER TABLE ONLY bank_api.operations
    ADD CONSTRAINT operations_wallet_fk FOREIGN KEY (wallet_id) REFERENCES bank_api.wallets(id);


-- Completed on 2022-06-03 20:55:22

--
-- PostgreSQL database dump complete
--

