package com.travelingapp.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * Create DataBase
 * */
public class DBOpenHelper extends SQLiteOpenHelper{
	private static final String DATANAME="travelling21.db";
	private static final int DATAVERSION=2;
	public DBOpenHelper(Context context) {
		super(context, DATANAME, null, DATAVERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL("CREATE TABLE detailinfo (id integer primary key autoincrement, info varchar(40), mediatype varchar(40))");//执行有更改行为的sql语句
		db.execSQL("CREATE TABLE linkinfo (id integer primary key autoincrement, infoid integer, text varchar(40), url varchar(40))");
		db.execSQL("CREATE TABLE fastfactsinfo (id integer primary key autoincrement, infoid integer, fastfacts varchar(40))");
		db.execSQL("CREATE TABLE eventcalendarinfo (id integer primary key autoincrement, day varchar(40), month varchar(40), title varchar(40), datainfo varchar(40), text varchar(40), content varchar(40))");
		db.execSQL("CREATE TABLE scoreinfo (id integer primary key autoincrement, score integer, comment varchar(20), infoid integer)");
		
		//TopatractionDetail
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('The seat of Canada''s federal government and the setting for national celebrations the year round,Parliament Hill is the most visited Ottawa attraction.Truly a must-see!', 'pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Rideau Hall in Ottawa is the official residence and workplace of the Governor General of Canada - an impressive mansion surrounded by fabulous heritage gardens.','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('An historic waterway filled with boaters spring through fall and the world''s largest naturally frozen skating rink in winter – the Rideau Canal winds through the heart of Ottawa before connecting with the Ottawa River','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('An historic farmers'' market and shopping district by day, a favourite gathering place of restaurants and clubs by night - the ByWard Market just east','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located just steps from Parliament Hill in downtown Ottawa, the National Gallery of Canada is the country''s showcase of the visual arts and a spectacular architectural Located just steps from Parliament Hill in downtown Ottawa, the National Gallery of Canada is the country''s showcase of the visual arts and a spectacular architectural','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located on the shores of the Ottawa River directly across from Parliament Hill, the Canadian Museum of Civilization is a stunning landmark building that celebrates the achievements and histories','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located next to the National Gallery of Canada, the Royal Canadian Mint is one of the world''s most respected manufacturers of collector and commemorative coins, gold','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located on the western edge of downtown next to the Ottawa River on LeBreton Flats, the Canadian War Museum is a striking building that houses a vast collection devoted to','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located in the heart of downtown next to the Rideau Canal, the National Arts Centre (NAC) is Canada''s premier showcase of the performing arts. ','pic')");
		//HotelDetail
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Located next door to the Parliament Buildings, the landmark Fairmont Château Laurier hotel in Ottawa is a magnificent limestone edifice with turrets and masonry reminiscent of a French château. This luxury Ottawa hotel enchants guests with its charm and stateliness.','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('located just minutes from downtown. Conveniently situated away from congestion and crowds, providing you with a refreshing opportunity to experience choices and flexibility.','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Hotel Indigo Ottawa is designed as a calming oasis and provides guests with a relaxing, refreshing and rejuvenating experience that changes with the seasons. This sophisticated boutique hotel in downtown Ottawa is ideal for those traveling for business or pleasure. Leisure travelers who are seeking a unique hotel experience can escape to our Ottawa hotel, which is conveniently located near a variety of local attractions.','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('The Westin Ottawa Hotel is your destination for revitalizing comfort. Whether visiting for business or pleasure, treat yourself to unparalleled views of Parliament Hill and the Rideau Canal or the historic Byward Market.','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('As the leading four-diamond hotel, conference, golf, spa and fine-dining destination in the national capital region, Brookstreet distinguishes itself through rapt attention to the smallest details, through impeccable service and the finest amenities.','pic')");
		//EatDetail
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Play is the creation of Stephen Beckta and Chef Michael Moffatt of the renowned Beckta dining & wine, offering extraordinary food & wine with fun, value and the same warm hospitality that it has become known for','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Stephen Beckta and Executive Chef / Partner Michael Moffatt, along with their team, inviting you enjoy the innovative flavour and warm hospitality of ottawa most award-winning restaurant','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('It is famous for shrimp, lobster and fish.  Food both times is excellent as is service.  If you are a big fan of seafood, you should not miss this gorgeous place.','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Delicious addictive whole-wheat pastries are hand-stretched, then float cooked and served piping hot, topped with butter and your choice of delectable flavours. Proudly satisfying your sweet tooth since 1978.','vid')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Stella Luna Gelato Café is a locally owned and operated family business that all began when a gal from Ottawa met a guy from Rome; fell in love with each other and with the dream to share some of life’s simplest pleasures with you….good health; relationships with family and friends; having a place to belong; sharing a laugh and eating some too-good-to-be-true gourmet, artisan gelato.','pic')");
		db.execSQL("INSERT INTO detailinfo (info, mediatype) VALUES('Coconut Lagoon is an Oasis for rich South Indian food, it specializes in a wide variety of Vegetarian and vegan dishes to offer at the Coconut Lagoon. Especially for hand-made Parathas, Idli, Dosa, currries and lot of Exotic seafood dishes. It has a wide variety of Biryani, Thali and our home-made desserts are unique.','pic')");
		
		//topattraction hyperlink
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(1, 'Parliament of Canada Website', 'http://www.parl.gc.ca/Visitors/index-esap')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(1,'Capital Sites and Canadian Heritage','http://www.ottawatourism.ca/en/visitors/what-to-do/capital-heritage')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(1,'Sound and Light Show','http://www.ottawatourism.ca/en/visitors/top-attractions/sound-and-light-show')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(2,'Rideau Hall Website','http://www.gg.ca/document.aspx?id=94')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(2,'From Far and Wide exhibit','http://www.ottawatourism.ca/en/features/from-far-and-wide')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(3,'Rideau Canal Skateway','http://www.ottawatourism.ca/en/visitors/top-attractions/rideau-canal-skateway')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(3,'Rideau Canal Skateway Map','http://www.rideauheritageroute.ca/en/')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(3,'Rideau Canal','http://www.pc.gc.ca/lhn-nhs/on/rideau/index.aspx')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(4,'ByWard Market Website','http://www.pc.gc.ca/lhn-nhs/on/rideau/index.aspx')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(4,'Entertainment & Nightlife','http://www.pc.gc.ca/lhn-nhs/on/rideau/index.aspx')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(5,'National Gallery of Canada Website','http://www.gallery.ca/en/')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(5,'Museums & Galleries','http://www.ottawatourism.ca/en/visitors/what-to-do/museums-and-galleries')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(6,'Canadian Museum of Civilization','http://www.civilization.ca/splash')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(6,'Website','http://www.ottawatourism.ca/en/visitors/top-attractions/canadian-museum-of-civilization/vodou')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(6,'Vodou Exhibit','http://www.ottawatourism.ca/en/visitors/top-attractions/canadian-museum-of-civilization/vodou')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(7,'Royal Canadian Mint website','http://www.mint.ca/')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(7,'Ottawa Museums & Galleries','http://www.ottawatourism.ca/en/visitors/what-to-do/museums-and-galleries')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(8,'Canadian War Museum Website','http://www.warmuseum.ca/splash')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(8,'Museums & Galleries','http://www.ottawatourism.ca/en/visitors/what-to-do/museums-and-galleries')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(9,'NAC Website','http://nac-cna.ca/')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(9,'Entertainment & Nightlife','http://www.ottawatourism.ca/en/visitors/what-to-do/entertainment-and-nightlife')");
		//Hotel hyperlink
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(10,'Hotel Website','http://www.fairmont.com/laurier-ottawa')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(11,'Hotel Website','http://www.marriott.com/hotels/travel/yowoe-courtyard-ottawa-east/?pid=corptbta&scid=b661a3c4-9c47-48c8-9e13-75b66089dd79')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(12,'Hotel Website','http://www.ichotelsgroup.com/hotelindigo/hotels/us/en/ottawa/yowid/hoteldetail')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(13,'Hotel Website','http://www.thewestinottawa.com/?EM=EM_aa_TripAdvisor_STWD_BusinessListings_WI_1083_NAD_FM')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(14,'Hotel Website','http://www.thewestinottawa.com/?EM=EM_aa_TripAdvisor_STWD_BusinessListings_WI_1083_NAD_FM')");
		//Eat hyperlink
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(15,'Website','http://www.playfood.ca')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(16,'Website','http://www.beckta.com')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(17,'Website','http://www.pelicanfisheryandgrill.com')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(18,'Website','http://www.beavertailsinc.com')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(19,'Website','http://slgelato.com')");
		db.execSQL("INSERT INTO linkinfo (infoid, text, url) VALUES(20,'Website','http://www.coconutlagoon.ca')");

		//topattraction facts
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(1,'The original structure burned to the ground in a tragic fire in 1916 - except for the Library, which was saved by a quick-thinking employee who closed the Library''s massive steel doors.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(2,'Rideau Hall was built in 1838 by early Ottawa lumber baron Thomas MacKay; it became the permanent residence of the Governor General''s in 1867.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(3,'The Rideau Canal stretches from Ottawa and the Ottawa River 202 kilometres south to Lake Ontario and the St. Lawrence River at Kingston, connecting beautiful lakes and rivers through a series of 45 locks.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(4,'Established by Lieutenant-Colonel John By in 1826, the ByWard Market is one of Canada''s oldest and largest public markets; farmers and craft merchants from across the Capital Region gather to their wares daily.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(5,'Created in 1880, the National Gallery is among Canada''s oldest national cultural institutions.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(5,'Designed by famed architect Moshe Safdie, the Gallery''s current building opened in 1988.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(6,'Canada Hall lets visitors walk through 1000 years of Canadian history, including townscapes and environments from across the country, from pre-European settlement to the present day.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(7,'Guided tours of the Mint let visitors watch coins being made from galleries high above the manufacturing floor while learning about the craft of coin making from concept to finished product.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(8,'Opened in 2005, the Museum is the newest national museum and has quickly become a favorite stop for visitors.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(9,'The NAC presents full seasons of English Theatre, French Theatre, Dance and Orchestra.')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(9,'In addition to in-house productions, the Centre plays host to variety and Broadway programming plus special festivals.')");
		//hotel addresses
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(10,'1 Rideau Street, Ottawa, Ontario K1N 8S7')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(11,'200 Coventry Road · Ottawa, Ontario K1K 4S3')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(12,'123 Metcalfe Street   Ottawa ,  Ontario  K1P 5L9 ')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(13,'11 Colonel By Drive • Ottawa, Ontario K1N 9H4')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(14,'525 Legget Drive, Ottawa, Ontario K2K 2W2')");
		//eat addresses
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(15,'1 York Street, Ottawa, Ontario, K1N 5S7 ')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(16,'226 Nepean Street, Ottawa, Ontario K2P 0B8')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(17,'1500 Bank St, Ottawa, Ontario, K1H 7Z2')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(18,'69 George Street, Ottawa, Ontario K1N 7G1')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(19,'1103 Bank Street, Ottawa, Ontario, K1S 3X4')");
		db.execSQL("INSERT INTO fastfactsinfo (infoid, fastfacts) VALUES(20,'853 St. Laurent Blvd (Macarthur Avenue ), Ottawa, Ontario K1K 3B1')");
		

		//Calendar data
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(8, 'JAN', '100th season', 'Jan 8 - 26, 2013', 'Ottawa Little Theatre', 'As the Ottawa Little Theatre celebrates its centennial, it performs a play for each of the last ten decades. In January, enjoy All My Sons, a tragedy by Arthur Miller from the 1940s.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(10, 'JAN', 'WinterBites', 'Jan 10 -26, 2013', 'Various restaurants', 'Local restaurants offer three-course prix fixe menus for $15, $20 or $25 (lunch) or $25, $30 or $40 (dinner). Beverages, taxes, and gratuities are additional.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(18, 'JAN', 'Rideau Canal Skateway', 'Jan 18 - Mar 10, 2013', 'Rideau Canal', 'Every winter, 7.8 km (4.8 miles) of the Rideau Canal transforms into the world''s largest outdoor skating rink, as designated by Guinness World Records.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(21, 'JAN', 'Ottawa Senators', 'Jan 21 - Apr 27, 2013', 'Scotiabank Place', 'The Ottawa Senators take to the ice for 24 regular season home games at Scotiabank Place during their 22nd hockey season.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(5, 'MAY', 'Nature Unleashed: Inside Natural Disasters', 'Sep 28, 2012 - May 5, 2013', 'Canadian Museum of Nature', 'Explore the dramatic power of Earth''s forces through the natural phenomena of earthquakes, volcanoes, hurricanes and tornadoes.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(22, 'SEP', 'Kandahar: The Fighting Season', 'Nov 1, 2012 - Sep 22, 2013', 'Canadian War Museum', 'As part of a five-year documentary project, photographer Louie Palu accompanied Canadian soldiers in dangerous districts of Kandahar, and captured their world of firefights and exhausting foot patrols in an unforgiving landscape.')");
		db.execSQL("INSERT INTO eventcalendarinfo (day, month, title, datainfo, text, content) VALUES(23, 'FEB', 'Vodou: A Way of Life', 'Nov 15, 2012 - Feb 23, 2014', 'Canadian Museum of Civilization', 'Travel through this exhibition showcasing over 350 Haitian cult objects, all witness of the power of belief over destiny.')");

		//Commetn addresses
		db.execSQL("INSERT INTO scoreinfo (score, comment, infoid) VALUES(5,'very good',1)");
		db.execSQL("INSERT INTO scoreinfo (score, comment, infoid) VALUES(3,'not bad',2)");

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists person");
		onCreate(db);
		
	}
}
