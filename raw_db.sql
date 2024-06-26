-- public.merchants definition

-- Drop table

-- DROP TABLE public.merchants;

CREATE TABLE public.merchants (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	"name" text NOT NULL,
	deleted_at timestamptz NOT NULL DEFAULT now(),
	CONSTRAINT merchants_pkey PRIMARY KEY (id)
);


-- public.rarities definition

-- Drop table

-- DROP TABLE public.rarities;

CREATE TABLE public.rarities (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	"name" varchar NOT NULL,
	"level" int8 NOT NULL,
	color text NOT NULL DEFAULT 'FFFFFF'::text,
	deleted_at timestamptz NULL,
	CONSTRAINT rarity_name_key UNIQUE (name),
	CONSTRAINT rarity_pkey PRIMARY KEY (id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	"name" text NOT NULL,
	description text NULL,
	price numeric NOT NULL,
	id_rarity int8 NULL,
	image text NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id),
	CONSTRAINT public_products_id_rarity_fkey FOREIGN KEY (id_rarity) REFERENCES public.rarities(id)
);


-- public.products_merchants definition

-- Drop table

-- DROP TABLE public.products_merchants;

CREATE TABLE public.products_merchants (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	id_product int8 NULL,
	id_merchant int8 NULL,
	CONSTRAINT products_merchants_pkey PRIMARY KEY (id),
	CONSTRAINT public_products_merchants_id_merchant_fkey FOREIGN KEY (id_merchant) REFERENCES public.merchants(id),
	CONSTRAINT public_products_merchants_id_product_fkey FOREIGN KEY (id_product) REFERENCES public.products(id)
);

INSERT INTO public.merchants ("name",deleted_at) VALUES
	 ('Local Merchant','2024-04-22 03:34:23.666844+00'),
	 ('Traveling Merchant','2024-04-22 03:34:31.287053+00'),
	 ('Black Merchant','2024-04-22 03:34:47.883953+00');

INSERT INTO public.rarities ("name","level",color,deleted_at) VALUES
	 ('Common',1,'FFFFFF',NULL),
	 ('Uncommon',2,'008000',NULL),
	 ('Rare',3,'0000FF',NULL),
	 ('Epic',4,'800080',NULL),
	 ('Legendary',5,'FFFF00',NULL);

INSERT INTO public.products ("name",description,price,id_rarity,image) VALUES
	 ('Mask of Azaroth','Infamous mask one wore by Azaroth, the elder dragon. Nobody knows what it does or how it was created',999,5,'https://png.pngtree.com/png-vector/20230903/ourmid/pngtree-fantasy-mask-cutout-png-file-png-image_9953716.png'),
	 ('Boots of Swiftness','Enable you to walk in stealth',109,2,'https://r2.easyimg.io/rl532krro/boots.png'),
	 ('Gloves of Titan','Makes your grip strength into titan like strength. But it doesn''t last long, so use wisely.',85,2,'https://r2.easyimg.io/dofiae3wu/glove.png'),
	 ('Necklace of Aragog','It contains remnants of Aragog''s last power during the humanity dark era.',301,4,NULL),
	 ('Pirate Eyewear','Makes you look alike pirate',25,1,NULL),
	 ('Ring of Void','One of the fourth mystical ring left during human dark era. Contains mysterious and unfathomable power',611,5,NULL),
	 ('Shard of Aragog''s Sowrd','One of many shard of Aragog''s sword. Who knows how many of them are',999,5,NULL),
	 ('Ring of Cypher','Enable you to decypher old text',89,2,NULL),
	 ('Bag of Infinium','Hold items more than it looks',399,4,NULL),
	 ('Gem of Miranda','Remains of Magician Miranda',290,4,NULL);
INSERT INTO public.products ("name",description,price,id_rarity,image) VALUES
	 ('Cape of Elemental','Protects wearer against elemental attacks',380,4,NULL),
	 ('Oil Lamp','Longer lasting than torch',30,1,NULL),
	 ('Ring of Goliath','This ring is imbued with giant magic that can turn you into Giant with giant''s strength.',468,5,'https://upload.wikimedia.org/wikipedia/commons/6/6e/One_Ring.png'),
	 ('Torch','A simple torch to lighten your path, though it has limited uses',5,1,'https://png.pngtree.com/png-vector/20240322/ourmid/pngtree-torch-fire-on-stick-medieval-lamp-and-tool-png-image_12178957.png'),
	 ('Necklace of Mana','Increase your mana capacity and regeneration',281,3,'https://r2.easyimg.io/st94uelvw/amulet.png'),
	 ('Glasses of "Knowledge"','Makes you look more intelligent than ordinary people',10,1,'https://w7.pngwing.com/pngs/648/755/png-transparent-sunglasses-glasses-glass-lens-glasses.png'),
	 ('Frost Walker Boots','Makes any water you touch with your boots to turn into ice, basically you can walk on water.',399,3,'https://png.pngtree.com/png-vector/20240203/ourmid/pngtree-3d-render-of-blue-boots-png-image_11535805.png'),
	 ('Cape of Invisibility','Turn you invisible for set amount of time',877,4,'https://static.miraheze.org/criticalrolewiki/thumb/5/5e/Cabal%27s_Ruin_-_Jessica_Nguyen.png/800px-Cabal%27s_Ruin_-_Jessica_Nguyen.png'),
	 ('Ring of Misfortune','Brings misfortune to whoever wore this ring',199,2,'https://i.pinimg.com/originals/80/60/31/806031647164b83533320f99516ddb41.png'),
	 ('Ring of Fortune','Brings fortune to whoever wore this ring',499,4,'https://i.pinimg.com/originals/8b/f6/98/8bf698a34c1d55a97516f365cf4d58dd.png');
INSERT INTO public.products ("name",description,price,id_rarity,image) VALUES
	 ('Gloves of Mining','Keep those fatigue at bay by increasing your stamina',35,1,'https://i.pinimg.com/originals/80/87/8d/80878dac2d0ddbb5f2bde042fc5b173e.png');

	 INSERT INTO public.products_merchants (id_product,id_merchant) VALUES
	 (1,3),
	 (2,1),
	 (2,2),
	 (3,2),
	 (3,3),
	 (4,1),
	 (4,2),
	 (5,1),
	 (5,2),
	 (6,2);
INSERT INTO public.products_merchants (id_product,id_merchant) VALUES
	 (6,3),
	 (7,1),
	 (8,3),
	 (9,2),
	 (10,1),
	 (10,2),
	 (11,3),
	 (11,2),
	 (12,1),
	 (4,3);
INSERT INTO public.products_merchants (id_product,id_merchant) VALUES
	 (14,1),
	 (15,3),
	 (16,3),
	 (17,1),
	 (17,2),
	 (18,1),
	 (18,2),
	 (19,2),
	 (20,2),
	 (20,3);
INSERT INTO public.products_merchants (id_product,id_merchant) VALUES
	 (21,1),
	 (21,2),
	 (21,3);