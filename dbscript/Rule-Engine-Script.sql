PGDMP             	            x            syzegee_rule_engine    11.5    12.3 ;               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16409    syzegee_rule_engine    DATABASE     ?   CREATE DATABASE syzegee_rule_engine WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
 #   DROP DATABASE syzegee_rule_engine;
                sz_re_admin    false                       0    0    SCHEMA public    ACL     ?   REVOKE ALL ON SCHEMA public FROM rdsadmin;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    3            ?            1259    16458    sz_project_rules    TABLE     }  CREATE TABLE public.sz_project_rules (
    project_rules_id bigint NOT NULL,
    project_id bigint NOT NULL,
    rule_id bigint NOT NULL,
    rule_value character varying(120) NOT NULL,
    is_active boolean,
    created_by character varying(120),
    created_date timestamp without time zone,
    updated_by character varying(120),
    updated_date timestamp without time zone
);
 $   DROP TABLE public.sz_project_rules;
       public            postgres    false                       0    0    TABLE sz_project_rules    ACL     ;   GRANT ALL ON TABLE public.sz_project_rules TO sz_re_admin;
          public          postgres    false    206            ?            1259    16454    sz_project_rules_project_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_project_rules_project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.sz_project_rules_project_id_seq;
       public          postgres    false    206                       0    0    sz_project_rules_project_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.sz_project_rules_project_id_seq OWNED BY public.sz_project_rules.project_id;
          public          postgres    false    204                       0    0 (   SEQUENCE sz_project_rules_project_id_seq    ACL     M   GRANT ALL ON SEQUENCE public.sz_project_rules_project_id_seq TO sz_re_admin;
          public          postgres    false    204            ?            1259    16452 %   sz_project_rules_project_rules_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_project_rules_project_rules_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.sz_project_rules_project_rules_id_seq;
       public          postgres    false    206                       0    0 %   sz_project_rules_project_rules_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.sz_project_rules_project_rules_id_seq OWNED BY public.sz_project_rules.project_rules_id;
          public          postgres    false    203                       0    0 .   SEQUENCE sz_project_rules_project_rules_id_seq    ACL     S   GRANT ALL ON SEQUENCE public.sz_project_rules_project_rules_id_seq TO sz_re_admin;
          public          postgres    false    203            ?            1259    16456    sz_project_rules_rule_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_project_rules_rule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.sz_project_rules_rule_id_seq;
       public          postgres    false    206                       0    0    sz_project_rules_rule_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.sz_project_rules_rule_id_seq OWNED BY public.sz_project_rules.rule_id;
          public          postgres    false    205                       0    0 %   SEQUENCE sz_project_rules_rule_id_seq    ACL     J   GRANT ALL ON SEQUENCE public.sz_project_rules_rule_id_seq TO sz_re_admin;
          public          postgres    false    205            ?            1259    16424    sz_rule    TABLE     ?  CREATE TABLE public.sz_rule (
    rule_id bigint NOT NULL,
    rule_code character varying(120) NOT NULL,
    rule_name character varying(120) NOT NULL,
    rule_desc character varying(240),
    rule_type character varying(240),
    is_active boolean,
    created_by character varying(120),
    created_date timestamp without time zone,
    updated_by character varying(120),
    updated_date timestamp without time zone
);
    DROP TABLE public.sz_rule;
       public            postgres    false                       0    0    TABLE sz_rule    ACL     2   GRANT ALL ON TABLE public.sz_rule TO sz_re_admin;
          public          postgres    false    199            ?            1259    16437    sz_rule_details    TABLE     ?  CREATE TABLE public.sz_rule_details (
    rule_detail_id bigint NOT NULL,
    rule_id bigint NOT NULL,
    rule_detail_code character varying(120) NOT NULL,
    rule_detail_value character varying(240),
    is_active boolean,
    created_by character varying(120),
    created_date timestamp without time zone,
    updated_by character varying(120),
    updated_date timestamp without time zone
);
 #   DROP TABLE public.sz_rule_details;
       public            postgres    false                        0    0    TABLE sz_rule_details    ACL     :   GRANT ALL ON TABLE public.sz_rule_details TO sz_re_admin;
          public          postgres    false    202            ?            1259    16433 "   sz_rule_details_rule_detail_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_rule_details_rule_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.sz_rule_details_rule_detail_id_seq;
       public          postgres    false    202            !           0    0 "   sz_rule_details_rule_detail_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.sz_rule_details_rule_detail_id_seq OWNED BY public.sz_rule_details.rule_detail_id;
          public          postgres    false    200            "           0    0 +   SEQUENCE sz_rule_details_rule_detail_id_seq    ACL     P   GRANT ALL ON SEQUENCE public.sz_rule_details_rule_detail_id_seq TO sz_re_admin;
          public          postgres    false    200            ?            1259    16435    sz_rule_details_rule_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_rule_details_rule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.sz_rule_details_rule_id_seq;
       public          postgres    false    202            #           0    0    sz_rule_details_rule_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.sz_rule_details_rule_id_seq OWNED BY public.sz_rule_details.rule_id;
          public          postgres    false    201            $           0    0 $   SEQUENCE sz_rule_details_rule_id_seq    ACL     I   GRANT ALL ON SEQUENCE public.sz_rule_details_rule_id_seq TO sz_re_admin;
          public          postgres    false    201            ?            1259    16413    sz_rule_project    TABLE     ?  CREATE TABLE public.sz_rule_project (
    project_id bigint NOT NULL,
    customer_id character varying(120),
    project_code character varying(120) NOT NULL,
    project_name character varying(240) NOT NULL,
    project_desc character varying(240),
    is_active boolean,
    created_by character varying(120),
    created_date timestamp without time zone,
    updated_by character varying(120),
    updated_date timestamp without time zone
);
 #   DROP TABLE public.sz_rule_project;
       public            postgres    false            %           0    0    TABLE sz_rule_project    ACL     :   GRANT ALL ON TABLE public.sz_rule_project TO sz_re_admin;
          public          postgres    false    197            ?            1259    16411    sz_rule_project_project_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sz_rule_project_project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.sz_rule_project_project_id_seq;
       public          postgres    false    197            &           0    0    sz_rule_project_project_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.sz_rule_project_project_id_seq OWNED BY public.sz_rule_project.project_id;
          public          postgres    false    196            '           0    0 '   SEQUENCE sz_rule_project_project_id_seq    ACL     L   GRANT ALL ON SEQUENCE public.sz_rule_project_project_id_seq TO sz_re_admin;
          public          postgres    false    196            ?            1259    16422    sz_rule_rule_id_seq    SEQUENCE     |   CREATE SEQUENCE public.sz_rule_rule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.sz_rule_rule_id_seq;
       public          postgres    false    199            (           0    0    sz_rule_rule_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.sz_rule_rule_id_seq OWNED BY public.sz_rule.rule_id;
          public          postgres    false    198            )           0    0    SEQUENCE sz_rule_rule_id_seq    ACL     A   GRANT ALL ON SEQUENCE public.sz_rule_rule_id_seq TO sz_re_admin;
          public          postgres    false    198                       2604    16461 !   sz_project_rules project_rules_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_project_rules ALTER COLUMN project_rules_id SET DEFAULT nextval('public.sz_project_rules_project_rules_id_seq'::regclass);
 P   ALTER TABLE public.sz_project_rules ALTER COLUMN project_rules_id DROP DEFAULT;
       public          postgres    false    206    203    206            ?           2604    16462    sz_project_rules project_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_project_rules ALTER COLUMN project_id SET DEFAULT nextval('public.sz_project_rules_project_id_seq'::regclass);
 J   ALTER TABLE public.sz_project_rules ALTER COLUMN project_id DROP DEFAULT;
       public          postgres    false    206    204    206            ?           2604    16463    sz_project_rules rule_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_project_rules ALTER COLUMN rule_id SET DEFAULT nextval('public.sz_project_rules_rule_id_seq'::regclass);
 G   ALTER TABLE public.sz_project_rules ALTER COLUMN rule_id DROP DEFAULT;
       public          postgres    false    205    206    206            |           2604    16427    sz_rule rule_id    DEFAULT     r   ALTER TABLE ONLY public.sz_rule ALTER COLUMN rule_id SET DEFAULT nextval('public.sz_rule_rule_id_seq'::regclass);
 >   ALTER TABLE public.sz_rule ALTER COLUMN rule_id DROP DEFAULT;
       public          postgres    false    198    199    199            }           2604    16440    sz_rule_details rule_detail_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_rule_details ALTER COLUMN rule_detail_id SET DEFAULT nextval('public.sz_rule_details_rule_detail_id_seq'::regclass);
 M   ALTER TABLE public.sz_rule_details ALTER COLUMN rule_detail_id DROP DEFAULT;
       public          postgres    false    202    200    202            ~           2604    16441    sz_rule_details rule_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_rule_details ALTER COLUMN rule_id SET DEFAULT nextval('public.sz_rule_details_rule_id_seq'::regclass);
 F   ALTER TABLE public.sz_rule_details ALTER COLUMN rule_id DROP DEFAULT;
       public          postgres    false    202    201    202            {           2604    16416    sz_rule_project project_id    DEFAULT     ?   ALTER TABLE ONLY public.sz_rule_project ALTER COLUMN project_id SET DEFAULT nextval('public.sz_rule_project_project_id_seq'::regclass);
 I   ALTER TABLE public.sz_rule_project ALTER COLUMN project_id DROP DEFAULT;
       public          postgres    false    197    196    197                      0    16458    sz_project_rules 
   TABLE DATA                 public          postgres    false    206   ?D       	          0    16424    sz_rule 
   TABLE DATA                 public          postgres    false    199   ?E                 0    16437    sz_rule_details 
   TABLE DATA                 public          postgres    false    202   PG                 0    16413    sz_rule_project 
   TABLE DATA                 public          postgres    false    197   ?L       *           0    0    sz_project_rules_project_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.sz_project_rules_project_id_seq', 1, false);
          public          postgres    false    204            +           0    0 %   sz_project_rules_project_rules_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.sz_project_rules_project_rules_id_seq', 83, true);
          public          postgres    false    203            ,           0    0    sz_project_rules_rule_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.sz_project_rules_rule_id_seq', 1, false);
          public          postgres    false    205            -           0    0 "   sz_rule_details_rule_detail_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.sz_rule_details_rule_detail_id_seq', 274, true);
          public          postgres    false    200            .           0    0    sz_rule_details_rule_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.sz_rule_details_rule_id_seq', 1, false);
          public          postgres    false    201            /           0    0    sz_rule_project_project_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.sz_rule_project_project_id_seq', 180, true);
          public          postgres    false    196            0           0    0    sz_rule_rule_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.sz_rule_rule_id_seq', 85, true);
          public          postgres    false    198            ?           2606    16465 &   sz_project_rules sz_project_rules_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.sz_project_rules
    ADD CONSTRAINT sz_project_rules_pkey PRIMARY KEY (project_rules_id);
 P   ALTER TABLE ONLY public.sz_project_rules DROP CONSTRAINT sz_project_rules_pkey;
       public            postgres    false    206            ?           2606    16446 $   sz_rule_details sz_rule_details_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.sz_rule_details
    ADD CONSTRAINT sz_rule_details_pkey PRIMARY KEY (rule_detail_id);
 N   ALTER TABLE ONLY public.sz_rule_details DROP CONSTRAINT sz_rule_details_pkey;
       public            postgres    false    202            ?           2606    16432    sz_rule sz_rule_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.sz_rule
    ADD CONSTRAINT sz_rule_pkey PRIMARY KEY (rule_id);
 >   ALTER TABLE ONLY public.sz_rule DROP CONSTRAINT sz_rule_pkey;
       public            postgres    false    199            ?           2606    16421 $   sz_rule_project sz_rule_project_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.sz_rule_project
    ADD CONSTRAINT sz_rule_project_pkey PRIMARY KEY (project_id);
 N   ALTER TABLE ONLY public.sz_rule_project DROP CONSTRAINT sz_rule_project_pkey;
       public            postgres    false    197            ?           2606    16447    sz_rule_details sz_rule_fkid    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sz_rule_details
    ADD CONSTRAINT sz_rule_fkid FOREIGN KEY (rule_id) REFERENCES public.sz_rule(rule_id);
 F   ALTER TABLE ONLY public.sz_rule_details DROP CONSTRAINT sz_rule_fkid;
       public          postgres    false    3717    199    202            ?           2606    16471    sz_project_rules sz_rule_fkid    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sz_project_rules
    ADD CONSTRAINT sz_rule_fkid FOREIGN KEY (rule_id) REFERENCES public.sz_rule(rule_id);
 G   ALTER TABLE ONLY public.sz_project_rules DROP CONSTRAINT sz_rule_fkid;
       public          postgres    false    199    206    3717            ?           2606    16466 %   sz_project_rules sz_rule_project_fkid    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sz_project_rules
    ADD CONSTRAINT sz_rule_project_fkid FOREIGN KEY (project_id) REFERENCES public.sz_rule_project(project_id);
 O   ALTER TABLE ONLY public.sz_project_rules DROP CONSTRAINT sz_rule_project_fkid;
       public          postgres    false    3715    197    206               ?   x???=?0ཿ??(?M?N?R?V?Ц?D
-I#???2hG?o.x?$I?N$Yq??U??????J¸VY?},??)?:>??ne?mE)}?(?*U??>?+????W?u?}z>?0??8??B
$"?O??i?]?? ?o["'FN??p9}??????O?mЃ?'?'?a?r8?^9?vMg'O?k
+|=?"q???V????	???      	   V  x????o?0?w>?m)??;T???)D?k???????F???v????????????ly?L??-,??46/%????k&E??J`'kV??@?;iN?s??7??$'dE???Z??mĥs־??9??S?OF1DG?#?UE??*2+H?X0[???](A;???r?$1??g??/???z????|؊??UcKF[Y??5a?(BnBV???`?B??d'??cpL:i{??f{?^??ٟi???M???$&????n?ށ??bP?|??7Q{????c0?
?Xm??]?>?}[?4
Og??3??????d?
?Ϝiw??k?????'a?{         f  x???Ms?6???<?Ɍ%?f{?$??L???????	h ?"??B?$?#?^?=???<?????%?????O_?w????Zp?4?+=	X?`)&z?ho???h޿N_0???#;*&w??e??ܐi?????ǭ?^G??^?9????ѷ7???|?^??u?%?ѕMȕ?haC'a???㿹????????????׿?x???;?d??Y8??,2?+?t"?Yd?Wd?D??y??e?e?֎??8?SK&??5?K??x?Ć?vM???.UzB??U????R?z?!dg?&?%@?B?B?<?n??Bq?P>??gmz??t??{?0w5???]J???a ?*?펣?????ݎ2L?S?d????֜.??h?/?4?7?Z??ѓt??C????Ȋ?????~??:??@<t??n?qB???@???I0?AMQ\?cQ>?bBŶ)\V^?@@J?3?|ɑ???a?eJJ? l?a4D??$?AY?0????
%?[
?n??w???y
=?;8H?z%??wu@?v???)B_?x?P?O??ʥ???7????.\?E?$I??"i?"?O???V?liv?o9!????{??	????ܹc??,?$Ի?????7rO?L$R?{??Pz5y?U??e7?#?ك?9?rû?b?l7??LA?@<??a;?i<?2??Ķ????TS?E? H?xU I?֠?+Hr?VEj?R???)\??3??L????ᠦ??=F?CeE &?z?>0B?*es7Q?? |H?9?Q??
?7?tG]]??\??[??i?u?G??K?c&8H??j???n?	e??Z?]????g?????a????Z????1?ɸ`J??/M?P?5q??2N????r??Ϸ?Q"{?H??m???n?p?K???t??;?.z???žX??b???7?yH?-?????!Z?55I?γ?3MAMX?9???&`z8?J¦$!?9?Ej/@??j?u%!?=E BP?#vc? ?9??&0?????o??P????ͱC???*Ԉv.????q??\%???3?yZ??vr?e?-X?ˣ9?ڢ8???@[nP??.SiR??	????/???@
/?????
-??OI??O!T~-	E?q?5??,?a ??:s?w5/?z3???h} yue??-???????j@)????&?-??????v?J???'????֕?N???{.ݵ?Nb?l?~W???F'3?˜?Ӎ f???E7w?m?l?.9????x??????@?B?0Fw?˓܇7#?R???K??tVg???n?{?Ob}?8G?Mwnv}}?l~??M??? I????g?չW?5IXZ??ʪ?*??Ң?????P/^??p         ?   x???9?@?????!H?+??ū]?? +9?=??n?Q?Ԃ???޼bf?(ن?D?n?3N??F?ɐY??j???p?5J?9?Gh
Z2|?"??CE}???T??-??T##???3?>?^M?+??a??-x??.????F?Ym.X?R????@]oxB??hn??-[ki?67e9/lL?q??????qG??ʤ??Be?Qi?2??|S?C?q?!4?     