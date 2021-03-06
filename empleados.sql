PGDMP                         z            empleado    10.18    10.18 '               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    24579    empleado    DATABASE     ?   CREATE DATABASE empleado WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE empleado;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    24593    area    TABLE     \   CREATE TABLE public.area (
    id_area integer NOT NULL,
    area character varying(255)
);
    DROP TABLE public.area;
       public         postgres    false    3            ?            1259    24591    area_id_area_seq    SEQUENCE     ?   CREATE SEQUENCE public.area_id_area_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.area_id_area_seq;
       public       postgres    false    197    3                       0    0    area_id_area_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.area_id_area_seq OWNED BY public.area.id_area;
            public       postgres    false    196            ?            1259    24601    empleado    TABLE     ?  CREATE TABLE public.empleado (
    id_empleado bigint NOT NULL,
    cedula character varying(20),
    correo character varying(300),
    estado character varying(255),
    fecha_hora_ingreso timestamp without time zone,
    fecha_ingreso date,
    id_area bigint,
    id_identificacion_tipo bigint,
    id_pais integer,
    primer_apellido character varying(20),
    primer_nombre character varying(20),
    segundo_apellido character varying(20),
    segundo_nombre character varying(50)
);
    DROP TABLE public.empleado;
       public         postgres    false    3            ?            1259    24599    empleado_id_empleado_seq    SEQUENCE     ?   CREATE SEQUENCE public.empleado_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.empleado_id_empleado_seq;
       public       postgres    false    3    199                       0    0    empleado_id_empleado_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.empleado_id_empleado_seq OWNED BY public.empleado.id_empleado;
            public       postgres    false    198            ?            1259    24612    pais    TABLE     \   CREATE TABLE public.pais (
    id_pais integer NOT NULL,
    pais character varying(255)
);
    DROP TABLE public.pais;
       public         postgres    false    3            ?            1259    24610    pais_id_pais_seq    SEQUENCE     ?   CREATE SEQUENCE public.pais_id_pais_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pais_id_pais_seq;
       public       postgres    false    201    3                       0    0    pais_id_pais_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.pais_id_pais_seq OWNED BY public.pais.id_pais;
            public       postgres    false    200            ?            1259    24620    tipo_identificacion    TABLE     ?   CREATE TABLE public.tipo_identificacion (
    id_identificacion_tipo integer NOT NULL,
    tipo_identificacion character varying(255)
);
 '   DROP TABLE public.tipo_identificacion;
       public         postgres    false    3            ?            1259    24618 .   tipo_identificacion_id_identificacion_tipo_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_identificacion_id_identificacion_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 E   DROP SEQUENCE public.tipo_identificacion_id_identificacion_tipo_seq;
       public       postgres    false    203    3                       0    0 .   tipo_identificacion_id_identificacion_tipo_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.tipo_identificacion_id_identificacion_tipo_seq OWNED BY public.tipo_identificacion.id_identificacion_tipo;
            public       postgres    false    202            ?
           2604    24596    area id_area    DEFAULT     l   ALTER TABLE ONLY public.area ALTER COLUMN id_area SET DEFAULT nextval('public.area_id_area_seq'::regclass);
 ;   ALTER TABLE public.area ALTER COLUMN id_area DROP DEFAULT;
       public       postgres    false    196    197    197            ?
           2604    24604    empleado id_empleado    DEFAULT     |   ALTER TABLE ONLY public.empleado ALTER COLUMN id_empleado SET DEFAULT nextval('public.empleado_id_empleado_seq'::regclass);
 C   ALTER TABLE public.empleado ALTER COLUMN id_empleado DROP DEFAULT;
       public       postgres    false    198    199    199            ?
           2604    24615    pais id_pais    DEFAULT     l   ALTER TABLE ONLY public.pais ALTER COLUMN id_pais SET DEFAULT nextval('public.pais_id_pais_seq'::regclass);
 ;   ALTER TABLE public.pais ALTER COLUMN id_pais DROP DEFAULT;
       public       postgres    false    200    201    201            ?
           2604    24623 *   tipo_identificacion id_identificacion_tipo    DEFAULT     ?   ALTER TABLE ONLY public.tipo_identificacion ALTER COLUMN id_identificacion_tipo SET DEFAULT nextval('public.tipo_identificacion_id_identificacion_tipo_seq'::regclass);
 Y   ALTER TABLE public.tipo_identificacion ALTER COLUMN id_identificacion_tipo DROP DEFAULT;
       public       postgres    false    203    202    203            
          0    24593    area 
   TABLE DATA               -   COPY public.area (id_area, area) FROM stdin;
    public       postgres    false    197   ?+                 0    24601    empleado 
   TABLE DATA               ?   COPY public.empleado (id_empleado, cedula, correo, estado, fecha_hora_ingreso, fecha_ingreso, id_area, id_identificacion_tipo, id_pais, primer_apellido, primer_nombre, segundo_apellido, segundo_nombre) FROM stdin;
    public       postgres    false    199   ?+                 0    24612    pais 
   TABLE DATA               -   COPY public.pais (id_pais, pais) FROM stdin;
    public       postgres    false    201   ?,                 0    24620    tipo_identificacion 
   TABLE DATA               Z   COPY public.tipo_identificacion (id_identificacion_tipo, tipo_identificacion) FROM stdin;
    public       postgres    false    203   ?,                  0    0    area_id_area_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.area_id_area_seq', 6, true);
            public       postgres    false    196                       0    0    empleado_id_empleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.empleado_id_empleado_seq', 8, true);
            public       postgres    false    198                       0    0    pais_id_pais_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pais_id_pais_seq', 2, true);
            public       postgres    false    200                        0    0 .   tipo_identificacion_id_identificacion_tipo_seq    SEQUENCE SET     \   SELECT pg_catalog.setval('public.tipo_identificacion_id_identificacion_tipo_seq', 4, true);
            public       postgres    false    202            ?
           2606    24598    area area_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.area
    ADD CONSTRAINT area_pkey PRIMARY KEY (id_area);
 8   ALTER TABLE ONLY public.area DROP CONSTRAINT area_pkey;
       public         postgres    false    197            ?
           2606    24609    empleado empleado_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public         postgres    false    199            ?
           2606    24617    pais pais_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (id_pais);
 8   ALTER TABLE ONLY public.pais DROP CONSTRAINT pais_pkey;
       public         postgres    false    201            ?
           2606    24625 ,   tipo_identificacion tipo_identificacion_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.tipo_identificacion
    ADD CONSTRAINT tipo_identificacion_pkey PRIMARY KEY (id_identificacion_tipo);
 V   ALTER TABLE ONLY public.tipo_identificacion DROP CONSTRAINT tipo_identificacion_pkey;
       public         postgres    false    203            ?
           2606    24636 $   empleado fk2eo3m8pcqxqvl2duw1o46aju7    FK CONSTRAINT     ?   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk2eo3m8pcqxqvl2duw1o46aju7 FOREIGN KEY (id_pais) REFERENCES public.pais(id_pais);
 N   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fk2eo3m8pcqxqvl2duw1o46aju7;
       public       postgres    false    201    199    2698            ?
           2606    24626 $   empleado fk8t1rolsy3jymnkqmhi4bviq0j    FK CONSTRAINT     ?   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk8t1rolsy3jymnkqmhi4bviq0j FOREIGN KEY (id_identificacion_tipo) REFERENCES public.tipo_identificacion(id_identificacion_tipo);
 N   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fk8t1rolsy3jymnkqmhi4bviq0j;
       public       postgres    false    199    2700    203            ?
           2606    24631 $   empleado fkcrgfx095l48pgeuc4txw5ca8j    FK CONSTRAINT     ?   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fkcrgfx095l48pgeuc4txw5ca8j FOREIGN KEY (id_area) REFERENCES public.area(id_area);
 N   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fkcrgfx095l48pgeuc4txw5ca8j;
       public       postgres    false    197    2694    199            
   ]   x?3?tL????,.)JL????2?t??K?K?LL-J?2???K+JLJ?&??EL8?R?jM9CsR?J???8?S??2???
e?E@?+F??? 4z         {   x?3?4444323316??/NN,??M??/?C;$g??楖?%??1??s?g?????????????????????????	T$?i?i?????A???ΎA?^?A???>>???.??A.?\1z\\\ ?y?            x?3?t????u?t?2?v?????? 8a         G   x?3?tNM)?I?2?2RRR+J???R?2??9???JR?L8R?r3??\?R?3s?b???? 	;?     