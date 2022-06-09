--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bill_of_materials; Type: TABLE; Schema: public; Owner: kkc; Tablespace: 
--

CREATE TABLE bill_of_materials (
    id bigint NOT NULL,
    measure integer NOT NULL,
    product_model_id bigint,
    raw_material_id bigint
);


ALTER TABLE public.bill_of_materials OWNER TO kkc;

--
-- Name: cost_of_goods; Type: TABLE; Schema: public; Owner: kkc; Tablespace: 
--

CREATE TABLE cost_of_goods (
    id bigint NOT NULL,
    cost double precision NOT NULL,
    product_model_id bigint
);


ALTER TABLE public.cost_of_goods OWNER TO kkc;

--
-- Name: costooo; Type: SEQUENCE; Schema: public; Owner: kkc
--

CREATE SEQUENCE costooo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.costooo OWNER TO kkc;

--
-- Name: default_rates; Type: TABLE; Schema: public; Owner: kkc; Tablespace: 
--

CREATE TABLE default_rates (
    id bigint NOT NULL,
    admin_markup double precision NOT NULL,
    rate_per_hour double precision NOT NULL,
    retail_markup double precision NOT NULL,
    tax_rate integer NOT NULL,
    wholesale_markup double precision NOT NULL
);


ALTER TABLE public.default_rates OWNER TO kkc;

--
-- Name: products; Type: TABLE; Schema: public; Owner: kkc; Tablespace: 
--

CREATE TABLE products (
    id bigint NOT NULL,
    p_name character varying(255)
);


ALTER TABLE public.products OWNER TO kkc;

--
-- Name: question_generator; Type: SEQUENCE; Schema: public; Owner: kkc
--

CREATE SEQUENCE question_generator
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_generator OWNER TO kkc;

--
-- Name: raw_materials; Type: TABLE; Schema: public; Owner: kkc; Tablespace: 
--

CREATE TABLE raw_materials (
    id bigint NOT NULL,
    rm_cost double precision NOT NULL,
    rm_name character varying(255)
);


ALTER TABLE public.raw_materials OWNER TO kkc;

--
-- Data for Name: bill_of_materials; Type: TABLE DATA; Schema: public; Owner: kkc
--

COPY bill_of_materials (id, measure, product_model_id, raw_material_id) FROM stdin;
2908	1	2540	2523
2909	5	2540	2396
2912	5	2550	2396
2938	2	2551	2461
2939	1	2551	2397
\.


--
-- Data for Name: cost_of_goods; Type: TABLE DATA; Schema: public; Owner: kkc
--

COPY cost_of_goods (id, cost, product_model_id) FROM stdin;
12	517	2540
15	500	2550
\.


--
-- Name: costooo; Type: SEQUENCE SET; Schema: public; Owner: kkc
--

SELECT pg_catalog.setval('costooo', 19, true);


--
-- Data for Name: default_rates; Type: TABLE DATA; Schema: public; Owner: kkc
--

COPY default_rates (id, admin_markup, rate_per_hour, retail_markup, tax_rate, wholesale_markup) FROM stdin;
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: kkc
--

COPY products (id, p_name) FROM stdin;
2540	Adult Dressing Gown
2541	Adult Dressing Gown L
2542	Adult Dressing Gown M
2543	Adult Dressing Gown S
2544	Adult kanga
2545	Adult Kanga Standard Mask with Elastic
2546	Adult Kanga Standard Mask with Ties
2547	Adult Kilifi shorts
2548	Adult Patched Kilifi Shorts
2549	Adult Patched Tigoni Shorts
2550	Adult Plain Mask with toggles
2551	Adult Tigoni shorts (with pom pom trim)
2552	Adult Vest Tanks
2553	Advent Calender
2554	Animal string (baby Elephants with beads)
2555	Animal string (mixed animals and beads)medium
2556	Animal string (mixed baby animals with beads)
2557	Apron Feather
2558	Apron Kanga frilled
2559	Apron Plain With Kanga trim
2560	Apron PVC
2561	Baby Bib
2562	Baby Blanket (fleece)
2563	Baby Blanket( flannel)
2564	Baby Booties
2565	Baby Changing Mat
2566	Baby Dress 0-3months
2567	Baby Hat 0-3
2568	Baby Onesie 0-3months
2569	Baby Set 4 Pack 0-3months
2570	Baby towel
2571	Back pack (large)
2572	Back pack (small)
2573	Back pack patched (large)
2574	Back pack patched (small)
2575	Baggage tag Kanga
2576	Beach bag Kanga
2577	Bean Bag Filled Inner
2578	Bean bags (Cover and inner)
2579	Beanbag cover
2580	Beanbag Inner cover
2581	Beanbag Seat
2582	Bespoke Quilt Blanket
2583	Bibs PVC
2584	Bibs towel
2585	Bird String with beads
2586	Bookmarks
2587	Boot Bag PVC
2588	Bunting Kanga
2589	Bunting PVC
2590	Camp chairs
2591	Canvas Hockey Bag
2592	Canvas Kazi Bag
2593	Canvas Pouch
2594	Canvas Travel Bag L
2595	Canvas Travel bag S
2596	Canvas wash Bag L
2597	Canvas Wash bag S
2598	Canvas Weekend wash bag
2599	Canvas Yoga Bag
2600	Cardlet
2601	Cheque Book Holder
2602	Cheza T-Shirt 12+
2603	Christmas Advent Bunting
2604	Christmas Bunting Shaped
2605	Christmas Bunting with Tassle
2606	Christmas Card
2607	Christmas card set of 6
2608	Christmas Cards
2609	Christmas Decoration
2610	Christmas Stockings
2611	Chritmas Bunting Shaped
2612	Clear Suncream Bag Malindi
2613	Clear T junction washbag
2614	CMIA Baby Blanket
2615	CMIA Ladies shorts
2616	CMIA Ladies T-shirts L
2617	Cot Bumper
2618	Cummerband & Bow tie
2619	Cushion cover (17x17 inches)
2620	Cushion cover (23x23 inches)
2621	Cushion Cover (Siku kuu njema)
2622	Cushion inner 14*14
2623	Cushion Inner 17*17
2624	Cushion Inner 23*23
2625	Dessert Plate (mellamine with feather print)
2626	Dessert plates (melamine with kanga print)
2627	Dessert plates (Pairs)
2628	Dinner Plate (melamine with feather print)
2629	Dinner plates (melamine with kanga print)
2630	Dinner plates (Pairs)
2631	Doorstopper
2632	Double bunting
2633	Double Oven Glove (Malindi Print)
2634	Double Oven Gloves Kanga
2635	Duffle bags
2636	Face Mask
2637	Feather (Single) napkins
2638	Feather cushion cover (17x17 inches)
2639	Feather cushion cover (23x23 inches)
2640	Feather Cushion with cover 14*14
2641	Feather cushion with cover(23x23 inches)
2642	Feather Flared Skirt
2643	Feather Napkins (set of 4)
2644	Fitted Lady Tank Top
2645	Flared skirt Patched
2646	Fleece blanket (L)
2647	Fleece blanket (S)
2648	Fleece Blanket patched (L)
2649	Fleece Blanket patched (S)
2650	Floor Cushion Covers
2651	Floor Cushion Inner
2652	Floor cushions
2653	Full Body Romper 0-3months
2654	Hair scrunchie
2655	Hooded towel (6-7Years)
2656	Horse Namna
2657	Hot Water Bottle Cover Reversible
2658	Hot Water Bottle with Cover
2659	Hot Water Rubber Bottle
2660	Ipad case Kanga
2661	Item Item 1000
2662	Kanga animals (L)
2663	Kanga animals (M)
2664	Kanga animals (S)
2665	Kanga Baby Hat
2666	Kanga bag (L)
2667	kanga bag (S)
2668	Kanga Balls L
2669	Kanga Balls S
2670	Kanga Bow Tie
2671	Kanga Christmas Gift Bag
2672	Kanga Coaster
2673	Kanga cooler
2674	KANGA CUSHION COMPLETE 17*17
2675	Kanga Dog Coat
2676	Kanga Eye Mask
2677	Kanga Flared Skirt
2678	Kanga gift bag
2679	Kanga Hanger
2680	Kanga Hankies
2681	Kanga Headband
2682	Kanga Hessian Stocking
2683	Kanga Hockey Stick Bag
2684	Kanga Hot water bottle cover
2685	Kanga Kids Onesie
2686	Kanga Kids Poncho
2687	Kanga Ladies Shirt
2688	Kanga Ladies Top
2689	Kanga Large Cololer
2690	Kanga Mask with Toggles
2691	Kanga Mens Shirt
2692	Kanga Mini Coolers
2693	Kanga Patched Bag L
2694	Kanga Patched Bag S
2695	Kanga Picnic Cups
2696	Kanga placemat oval (set of 6)
2697	Kanga placemat oval (set of 8)
2698	Kanga Rah Rah Skirt
2699	Kanga safari cooler
2700	Kanga Santa Hats
2701	Kanga scarves
2702	Kanga School Bag
2703	Kanga Shoe Bag
2704	Kanga Stationary Holder
2705	Kanga Sun Hat
2706	Kanga Sun Hat M
2707	Kanga Swimming Bag
2708	Kanga Teepee with Cushions
2709	Kanga Teepee without cushions
2710	Kanga Tote Bag
2711	Kanga Towel
2712	Kanga Travel Bag
2713	Kanga twill placemat (set of 4)
2714	Kanga twill placemat (single)
2715	Kanga Twill Placemats Set Of 3
2716	Kanga Umbrella
2717	Kanga wallet M
2718	Kanga Wallets (s)
2719	Kanga Wallets L
2720	Kanga Wallets M
2721	Kanga Weekender Bag
2722	Kanga Wrap Skirt L
2723	Kanga Wrap Trousers
2724	Kanga Wreath
2725	Karimu shorts (boxer shorts)
2726	Kazi bag
2727	Keep Calm Cardlet
2728	Kenya Kanga Sweets
2729	Kenya Kanga Water Bottles
2730	Kenya Kanga Wrapping Papers
2731	KENYA LOVE Cushions
2732	Kids CMIA Shirt Barrier Reef
2733	Kids dressing gown
2734	Kids Indian Trousers
2735	Kids Kanga Shorts
2736	Kids Kanga Standard Mask with Elastic
2737	Kids Kanga Standard Mask with Ties
2738	Kids Kilifi Shorts
2739	Kids mask with bag
2740	Kids Mini Shorts
2741	Kids Patched Tigoni Shorts
2742	Kids pinafore
2743	Kids PJ Set CMIA 12+yrs
2744	Kids PJ sets (T shirt & trousers)
2745	Kids Plain Standard Mask with Elastic
2746	Kids Plain Standard Mask with Ties
2747	Kids Ruffle Dress
2748	Kids Shaped Kanga Mask
2749	Kids Shaped Plain mask
2750	kids Shirt dress
2751	Kids Summer Dress
2752	Kids T-Shirt
2753	Kids Tigoni Shorts
2754	kids trousers
2755	Kids Umbrella Skirt
2756	Kikapu (large)
2757	Kikapu (medium)
2758	Kikapu (small)
2759	Kikapu L (With leather handles)
2760	Kikapu M (With leather handles)
2761	Kikapu S (With leather handles)
2762	Kikapu(XL)
2763	Kilifi Shorts Teens
2764	KKc Order 3090
2765	Ladies Kaftan
2766	Ladies kanga Trousers
2767	Ladies Pajama Shorts
2768	Ladies PJ Set
2769	Ladies T shirts
2770	Ladies Trousers & Tank Top Pajamas
2771	Lamp shade conical L
2772	Lamp shade conical S
2773	Lamp shade Round L
2774	Lamp shade Round XL
2775	Lamp stand small
2776	Lamp stands large
2777	Lampshade conical XS
2778	Large Cutlery Roll
2779	Little Santa Stocking
2780	Luggage Strap & Tags
2781	Make up bag Kanga
2782	Make up Feather T Junction
2783	Make your Own Wreath
2784	Malindi Adult Apron
2785	Malindi Cushion Cover
2786	Malindi Cushion Cover 17*17
2787	Malindi Napkins (set of 4)
2788	Malindi Placemats
2789	Malindi T Junction Washbag
2790	Mens Boxer shorts
2791	Mens Trousers
2792	Merry Christmas Bunting
2793	Meru Swimming Shorts
2794	Mini ipad case
2795	Mini Poof Cover
2796	Mini Pouf
2797	Mini Pouf inner
2798	Napkins (set of 6)
2799	Napkins (set of 8)
2800	Nappy bags
2801	Navy Blue Luxury Cracker with Silver Feathers
2802	Neckrest
2803	Nose Mask Kanga
2804	Oblong Cushions
2805	Olive Green Luxury Cracker with Gold Feathers
2806	Oven glove (pair)
2807	Oven Mitt (Malindi Print)
2808	Oven Mitts feather
2809	Passport covers
2810	patched cushion cover with inner (17*17 inches )
2811	patched cushion cover with inner (23*23 inches )
2812	Patched Cushion Covers(17x17 inches)
2813	Patched Cushion Covers(23x23 inches)
2814	patched kids kilifi shorts
2815	Patched kids Tigoni shorts
2816	Patched Kids Trousers
2817	Patched Ladies Trousers
2818	Patched Mens Trousers
2819	Patched Teens Kilifi shorts
2820	Patched Teens Tigoni shorts
2821	Pencil case kanga
2822	Pencil case PVC
2823	Pet Bed Large
2824	Pet Bed Small
2825	Pet Bed X-Large
2826	Picnic Basket L
2827	Picnic Baskets S
2828	Picnic blanket (double)
2829	Picnic blanket (single)
2830	Picnic blanket patchwork (double)
2831	Picnic blanket patchwork (single)
2832	picture Frame large
2833	picture frame medium
2834	Picture frame small
2835	Place mats feather set of 4
2836	Place mats feather set of 6
2837	Placemats (set of 6)
2838	Placemats (set of 8)
2839	Plain Face Mask
2840	Plain Umbrella
2841	Plastic Bag Holder
2842	Polo bag
2843	polystyrene balls
2844	Pot Holder Kanga
2845	Pouf (Cover and inner)
2846	Pouf cover
2847	Pouf inner
2848	Printed Cushion Cover
2849	PVC Kazi Bag
2850	PVC Lunch Box
2851	PVC Placemat
2852	Raha Bag (baby changing bag)
2853	Reverse Bags
2854	Ruffle Skirt
2855	Safari chairs Adults
2856	Safari chairs Kids
2857	Santa Christmas Sack
2858	School Bag Patched
2859	Seat belt cover
2860	Shoulder bag Kanga
2861	Shoulder bag Mariakani
2862	Silver Luxury Cracker with Navy Blue Feathers
2863	Silver Luxury Cracker with Sky Blue Malindi Print
2864	Single Christmas Card L
2865	Single napkin
2866	Sleeping Bag
2867	Small Cutlery Roll
2868	Summer shorts
2869	Suncream Bag
2870	T junction make up
2871	T Junction Wash bag
2872	Table runner (Malindi)S
2873	Table runner Feather (L)
2874	Table runner Feather/ (S)
2875	Table runner Kanga (L)
2876	Table runner Kanga (S)
2877	Table runner(Malindi)L
2878	Tea & Bag
2879	Tea Cosy Malindi
2880	Tea Towel (feather print)
2881	Teacosy
2882	Teen Boys Shorts
2883	Teens Indian Trousers
2884	Teens Patched Trousers
2885	Teens trousers
2886	Tigoni Shorts Teens
2887	Toast boxes
2888	Toto Apron Kanga
2889	Toto apron pvc
2890	Towel and swimming bag set
2891	Valentine Card L
2892	Valentine Card S
2893	Valentine Love Heart
2894	Wash bag (L)
2895	Wash bag (M)
2896	Washbag (S)
2897	Washbag Feather T Junction
2898	Weekend Wash bag Kanga
2899	Weekend Wash bag PVC
2900	Weekend Washbag Feather
2901	White Luxury Cracker with Gold Feathers
2902	Wine Bottle Cover
2903	Women Hoodie
2904	Wooden Hanging Kanga Deco
2905	Wrapping Paper-Feather-Gold on Green
2906	Xmass Stockins
2907	Yoga bag
\.


--
-- Name: question_generator; Type: SEQUENCE SET; Schema: public; Owner: kkc
--

SELECT pg_catalog.setval('question_generator', 2939, true);


--
-- Data for Name: raw_materials; Type: TABLE DATA; Schema: public; Owner: kkc
--

COPY raw_materials (id, rm_cost, rm_name) FROM stdin;
2396	100	Time Taken hours
2397	1000	Out Sourcing
2398	272	Kanga       Off Cuts
2399	858	Cotton Jersey (Band)
2400	180	Decron
2401	650	Printed Feather Material
2402	650	Printed Feather Off Cuts
2403	1050	Printed Feather Canvas
2404	760	Printed Feather PVC (B)
2405	760	Feather    PVC (B)    Off Cuts
2406	983	Printed Feather PVC (WC)
2407	983	Feather PVC (WC) Off Cuts
2408	665	Printed Malindi Fabric
2409	665	Printed Malindi Off Cuts
2410	100	Printed Malindi Boarder
2411	65	Pre-Cut Feather Cushion 17x17
2412	100	Pre-Cut Feather Cushion 23x23
2413	65	Pre-Cut Feather Napkin
2414	45	Pre-Cut Feather Napkin W.boarder
2415	75	Pre-Cut Feather Tea Towel
2416	350	Pre-Cut Malindi Table Runner (S)
2417	450	Pre-Cut Malindi Table Runner (L)
2418	150	Pre-Cut Malindi Tea Towel
2419	650	Printed Polka Dots
2420	650	Printed Dots Off Cuts
2421	500	Fleece
2422	500	Fleece Off Cuts
2423	230	Towel
2424	230	Towel Off Cuts
2425	302	Americani heavy
2426	172	Americani  light
2427	230	Blanket
2428	862	Canvas
2429	200	Flannel Baby
2430	560	Hessian
2431	345	Kikoi
2432	230	Leather
2433	431	Masai Shuka
2434	431	Masai Shuka Off Cuts
2435	80	Polly Cotton
2436	52	PVC Black
2437	1164	Ripstop
2438	135	Water proof White
2439	375	White Sheeting
2440	140	Bag Brass Adjusters
2441	120	Bag Brass Connector
2442	300	Bag Brass Hook
2443	6	Bag  SS Adjusters 1.25
2444	8	Bag  SS Adjusters 1.5
2445	5	Bag D Ring  1.25
2446	6	Bag D Ring  1.5
2447	5	Bag Slider Buckle        1.25
2448	50	Bag Rucksack Clips
2449	10	Button Decora
2450	5	Button Press
2451	5	Button Shirts
2452	20	Canvas  Iron-On
2453	280	Clear Plastic
2454	5	Cord Pull String Thick
2455	5	Cord Pull String Thin
2456	10	Elastic   1 1/4 inch
2457	10	Elastic   1 inch
2458	5	Elastic  Code 8
2459	155	Elastic 40mm Royal Blue
2460	142	Elastic Soft 25mm White
2461	142	Elastic Soft 25mm Black
2462	5	Elastic Button Hole
2463	5	Eyelets
2464	94	Foam  1/2 inch
2465	190	Foam 1/4 inch
2466	302	Hollow Fibre
2467	290	Insulation Alum dbl
2468	200	Kikapu S
2469	250	Kikapu M
2470	270	Kikapu L
2471	241	Netting
2472	5	Piping Cord
2473	525	Poly Balls
2474	20	Velcro 1.25
2475	5	Stat Set Coloured Pencils
2476	10	Stat Set Eraser
2477	30	Stat Set Marker Pen
2478	5	Stat Set Pencil
2479	5	Stat Set Ruler
2480	30	Stat Set  Scissors
2481	20	Stat Set Sharpener
2482	1075	Binding Biace
2483	1740	Binding Lace
2484	1340	Binding Pom Pom
2485	2155	Binding Pom Pom Jumbo
2486	10	Silk Ribbon 1.0 - Blue
2487	5	Ribbon Silk    0.5
2488	5	Ribbon Silk    0.25
2489	7	Ribbons Assorted
2490	9	Strapping Nylon   1.25
2491	7	Strapping Nylon   1.00
2492	36	Webbing Cotton Herring 25mm
2493	48	Webbing Cotton Herring 40mm
2494	73	Webbing Cotton Heavy W. 30mm
2495	80	Webbing Cotton HW 40mm
2496	61	Webbing Cotton Stripe    34mm
2497	50	Thread
2498	10	Zip Chain #7
2499	5	Zip Sliders #7
2500	112	Zip Chain #10
2501	112	Zip Sliders #10
2502	50	Zip - Jacket
2503	5	Zip Ordinary
2504	1000	Out Sourcing Labour Costs
2505	6	Labels
2506	10	Label  KK square
2507	5	Label  Guinea Fowl
2508	12	Label  Washing Instr
2509	7	Label  Website
2510	6	Size Labels
2511	4	SQ Apron
2512	6	SQ  Masai Shuka Fleece Blanket
2513	6	SQ  Masai Shuka Info
2514	6	SQ Masai Shuka Original
2515	6	SQ Masai Shuka Picnic Blanket
2516	4	SQ Napkins (KKC)
2517	4	SQ Napkins (TKC)
2518	4	SQ Oven Gloves
2519	4	SQ Picnic Blanket
2520	4	SQ Placemats
2521	4	SQ   Towel
2522	17	Wrap Adult Apron
2523	17	Wrap Kanga Cloth
2524	17	Wrap Kids Apron
2525	17	Wrap Napkins x 4
2526	17	Wrap Napkins x 6
2527	17	Wrap Napkins x 8
2528	17	Wrap Oven Gloves
2529	17	Wrap Towel
2530	36	Wrap Mens Kanga Shorts
2531	38	Wrap Ladies Kanga Shorts
2532	38	Wrap Ladies TKC Shorts
2533	38	Wrap Mens TKC Shorts
2534	38	Wrap Box - Tea Towels
2535	38	Wrap Box - Table Runner
2536	38	Wrap Box - Napkins x 6 TKC
2537	38	Wrap Box - Napkins x 8 TKC
2538	2	Bar Code  Thermo Rolls
2539	9	Stickers
\.


--
-- Name: bill_of_materials_pkey; Type: CONSTRAINT; Schema: public; Owner: kkc; Tablespace: 
--

ALTER TABLE ONLY bill_of_materials
    ADD CONSTRAINT bill_of_materials_pkey PRIMARY KEY (id);


--
-- Name: cost_of_goods_pkey; Type: CONSTRAINT; Schema: public; Owner: kkc; Tablespace: 
--

ALTER TABLE ONLY cost_of_goods
    ADD CONSTRAINT cost_of_goods_pkey PRIMARY KEY (id);


--
-- Name: default_rates_pkey; Type: CONSTRAINT; Schema: public; Owner: kkc; Tablespace: 
--

ALTER TABLE ONLY default_rates
    ADD CONSTRAINT default_rates_pkey PRIMARY KEY (id);


--
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: kkc; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: raw_materials_pkey; Type: CONSTRAINT; Schema: public; Owner: kkc; Tablespace: 
--

ALTER TABLE ONLY raw_materials
    ADD CONSTRAINT raw_materials_pkey PRIMARY KEY (id);


--
-- Name: fk7ixfqow2eh4whnwud5vrij6jb; Type: FK CONSTRAINT; Schema: public; Owner: kkc
--

ALTER TABLE ONLY cost_of_goods
    ADD CONSTRAINT fk7ixfqow2eh4whnwud5vrij6jb FOREIGN KEY (product_model_id) REFERENCES products(id);


--
-- Name: fkodo5niwxt8jawj6q8njnwlf55; Type: FK CONSTRAINT; Schema: public; Owner: kkc
--

ALTER TABLE ONLY bill_of_materials
    ADD CONSTRAINT fkodo5niwxt8jawj6q8njnwlf55 FOREIGN KEY (raw_material_id) REFERENCES raw_materials(id);


--
-- Name: fkqoukhcw6bfvhmboygbwie1x0u; Type: FK CONSTRAINT; Schema: public; Owner: kkc
--

ALTER TABLE ONLY bill_of_materials
    ADD CONSTRAINT fkqoukhcw6bfvhmboygbwie1x0u FOREIGN KEY (product_model_id) REFERENCES products(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

