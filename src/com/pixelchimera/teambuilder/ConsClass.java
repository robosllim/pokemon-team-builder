/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pixelchimera.teambuilder;

/**
 *
 * @author dans
 */

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsClass {
    
    public ConsClass(){
        // Initialize, then fill in the dex arrays
        SetDexNames();
        dexTotal = pkmnNames.length;
        SetDexTypes();

        // Sort the dex array
        // pkmnSorted = Arrays.asList(pkmnNames);
        // Collections.sort(pkmnSorted, String.CASE_INSENSITIVE_ORDER);
    }
    
    public int GetDexNum(String inName){
        // Return index of valid name, or -1 for invalid
        for (int i = 0; i < dexTotal; i++){
            if (inName.toUpperCase().compareTo(pkmnNames[i].toUpperCase()) == 0){
                return i;
            }
        }
        return -1;
    }
    
    private void SetDexNames(){
        String [] temp = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", 
        "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", 
        "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "NidoranF", "Nidorina", "Nidoqueen", 
        "NidoranM", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", 
        "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", 
        "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", 
        "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", 
        "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", 
        "Magneton", "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", 
        "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", 
        "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", 
        "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", 
        "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", 
        "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", 
        "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew", 
        "Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava", "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret", 
        "Furret", "Hoothoot", "Noctowl", "Ledyba", "Ledian", "Spinarak", "Ariados", "Crobat", "Chinchou", "Lanturn", 
        "Pichu", "Cleffa", "Igglybuff", "Togepi", "Togetic", "Natu", "Xatu", "Mareep", "Flaaffy", "Ampharos", 
        "Bellossom", "Marill", "Azumarill", "Sudowoodo", "Politoed", "Hoppip", "Skiploom", "Jumpluff", "Aipom", "Sunkern", 
        "Sunflora", "Yanma", "Wooper", "Quagsire", "Espeon", "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown", 
        "Wobbuffet", "Girafarig", "Pineco", "Forretress", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Granbull", "Qwilfish", 
        "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Magcargo", "Swinub", "Piloswine", 
        "Corsola", "Remoraid", "Octillery", "Delibird", "Mantine", "Skarmory", "Houndour", "Houndoom", "Kingdra", "Phanpy", 
        "Donphan", "Porygon2", "Stantler", "Smeargle", "Tyrogue", "Hitmontop", "Smoochum", "Elekid", "Magby", "Miltank", 
        "Blissey", "Raikou", "Entei", "Suicune", "Larvitar", "Pupitar", "Tyranitar", "Lugia", "Ho-oh", "Celebi", 
        "Treecko", "Grovyle", "Sceptile", "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", 
        "Mightyena", "Zigzagoon", "Linoone", "Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre", 
        "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow", "Swellow", "Wingull", "Pelipper", "Ralts", "Kirlia", 
        "Gardevoir", "Surskit", "Masquerain", "Shroomish", "Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada", "Ninjask", 
        "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", "Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty", 
        "Sableye", "Mawile", "Aron", "Lairon", "Aggron", "Meditite", "Medicham", "Electrike", "Manectric", "Plusle", 
        "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin", "Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord", 
        "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch", "Vibrava", "Flygon", "Cacnea", 
        "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish", 
        "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", 
        "Kecleon", "Shuppet", "Banette", "Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", 
        "Glalie", "Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Bagon", 
        "Shelgon", "Salamence", "Beldum", "Metang", "Metagross", "Regirock", "Regice", "Registeel", "Latias", "Latios", 
        "Kyogre", "Groudon", "Rayquaza", "Jirachi", "Deoxys", "Turtwig", "Grotle", "Torterra", "Chimchar", "Monferno", 
        "Infernape", "Piplup", "Prinplup", "Empoleon", "Starly", "Staravia", "Staraptor", "Bidoof", "Bibarel", "Kricketot", 
        "Kricketune", "Shinx", "Luxio", "Luxray", "Budew", "Roserade", "Cranidos", "Rampardos", "Shieldon", "Bastiodon", 
        "Burmy", "Wormadam Grass", "Wormadam Sandy", "Wormadam Trash", "Mothim", "Combee", "Vespiquen", "Pachirisu", "Buizel", "Floatzel", 
        "Cherubi", "Cherrim", "Shellos", "Gastrodon", "Ambipom", "Drifloon", "Drifblim", "Buneary", "Lopunny", "Mismagius", 
        "Honchkrow", "Glameow", "Purugly", "Chingling", "Stunky", "Skuntank", "Bronzor", "Bronzong", "Bonsly", "Mime Jr.", 
        "Happiny", "Chatot", "Spiritomb", "Gible", "Gabite", "Garchomp", "Munchlax", "Riolu", "Lucario", "Hippopotas", 
        "Hippowdon", "Skorupi", "Drapion", "Croagunk", "Toxicroak", "Carnivine", "Finneon", "Lumineon", "Mantyke", "Snover", 
        "Abomasnow", "Weavile", "Magnezone", "Lickilicky", "Rhyperior", "Tangrowth", "Electivire", "Magmortar", "Togekiss", "Yanmega", 
        "Leafeon", "Glaceon", "Gliscor", "Mamoswine", "Porygon-Z", "Gallade", "Probopass", "Dusknoir", "Froslass", "Rotom Normal", 
        "Rotom Heat", "Rotom Wash", "Rotom Frost", "Rotom Fan", "Rotom Mow", "Uxie", "Mesprit", "Azelf", "Dialga", "Palkia", 
        "Heatran", "Regigigas", "Giratina Altered", "Giratina Origin", "Cresselia", "Phione", "Manaphy", "Darkrai", "Shaymin Land", 
        "Shaymin Sky", "Arceus Normal", "Arceus Fire", "Arceus Water", "Arceus Electric", "Arceus Grass", "Arceus Ice", "Arceus Fighting", 
        "Arceus Poison", "Arceus Ground", "Arceus Flying", "Arceus Psychic", "Arceus Bug", "Arceus Rock", "Arceus Ghost", 
        "Arceus Dragon", "Arceus Dark", "Arceus Steel", "Victini", "Snivy", "Servine", 
        "Serperior", "Tepig", "Pignite", "Emboar", "Oshawott", "Dewott", "Samurott", "Patrat", "Watchog", "Lillipup", 
        "Herdier", "Stoutland", "Purrloin", "Liepard", "Pansage", "Simisage", "Pansear", "Simisear", "Panpour", "Simipour", 
        "Munna", "Musharna", "Pidove", "Tranquill", "Unfezant", "Blitzle", "Zebstrika", "Roggenrola", "Boldore", "Gigalith", 
        "Woobat", "Swoobat", "Drilbur", "Excadrill", "Audino", "Timburr", "Gurrdurr", "Conkeldurr", "Tympole", "Palpitoad", 
        "Seismitoad", "Throh", "Sawk", "Sewaddle", "Swadloon", "Leavanny", "Venipede", "Whirlipede", "Scolipede", "Cottonee", 
        "Whimsicott", "Petilil", "Lilligant", "Basculin", "Sandile", "Krokorok", "Krookodile", "Darumaka", "Darmanitan", "Maractus", 
        "Dwebble", "Crustle", "Scraggy", "Scrafty", "Sigilyph", "Yamask", "Cofagrigus", "Tirtouga", "Carracosta", "Archen", 
        "Archeops", "Trubbish", "Garbodor", "Zorua", "Zoroark", "Mincinno", "Cincinno", "Gothita", "Gothorita", "Gothitelle", 
        "Solosis", "Duosion", "Reuniclus", "Ducklett", "Swanna", "Vanillite", "Vanillish", "Vanilluxe", "Deerling", "Sawsbuck", 
        "Emolga", "Karrablast", "Escavalier", "Foongus", "Amoongus", "Frillish", "Jellicent", "Alomomola", "Joltik", "Galvantula", 
        "Ferroseed", "Ferrothorn", "Klink", "Klang", "Klinklang", "Tynamo", "Eelektrik", "Eelektross", "Elgyem", "Beheeyem", 
        "Litwick", "Lampent", "Chandelure", "Axew", "Fraxure", "Haxorus", "Cubchoo", "Beartic", "Cryogonal", "Shelmet", 
        "Accelgor", "Stunfisk", "Mienfoo", "Mienshao", "Druddigon", "Golett", "Golurk", "Pawniard", "Bisharp", "Bouffalant", 
        "Rufflet", "Braviary", "Vullaby", "Mandibuzz", "Heatmor", "Durant", "Deino", "Zweilous", "Hydreigon", "Larvesta", 
        "Volcarona", "Cobalion", "Terrakion", "Virizion", "Tornadus", "Thundurus", "Reshiram", "Zekrom", "Landorus", "Kyurem", 
        "Keldeo", "Meloetta", "Genesect"};
        pkmnNames = temp;
    }
    
    // TODO: alternate formes:
    // wormadam, rotom, giratina, skymin, zen-darmanitan, meloetta
    private void SetDexTypes(){
        int offset = 0; // if we ever need to stick someone in somewhere, use this
        pkmnTypes = new int[dexTotal][4];
        // Initialize, just to make sure we have no NULLs
        for (int i = 0; i < dexTotal; i++){
            for (int j = 0; j < 4; j++){
                pkmnTypes[i][j] = 17;   // Undefined, ??? type
            }
        }
        
        // Ability index:
        // 0 = Lightning Rod (ele dmg = 0)
        // 1 = Motor Drive (ele dmg = 0)
        // 2 = Volt Absorb (elec dmg = 0)
        // 3 = Storm Drain (wat dmg = 0)
        // 4 = Water Absorb (wat dmg = 0)
        // 5 = Sap Sipper (grs dmg = 0)
        // 6 = Flash Fire (fir dmg = 0)
        // 7 = Dry Skin (fir dmg x1.25, wat dmg = 0
        // 8 = Levitate (gnd dmg = 0)
        // 9 = Thick Fat (fir and ice dmg x0.5)
        // 10 = Wonder Guard (yeah...)
        // 11 = Heat Proof (fir dmg x0.5)
        
        pkmnTypes[offset+0][0] = 4;
        pkmnTypes[offset+0][1] = 7;
        pkmnTypes[offset+1][0] = 4;
        pkmnTypes[offset+1][1] = 7;
        pkmnTypes[offset+2][0] = 4;
        pkmnTypes[offset+2][1] = 7;
        pkmnTypes[offset+3][0] = 1;
        pkmnTypes[offset+4][0] = 1;
        pkmnTypes[offset+5][0] = 1;
        pkmnTypes[offset+5][1] = 9;
        pkmnTypes[offset+6][0] = 2;
        pkmnTypes[offset+7][0] = 2;
        pkmnTypes[offset+8][0] = 2;
        pkmnTypes[offset+9][0] = 11;
        pkmnTypes[offset+10][0] = 11;
        pkmnTypes[offset+11][0] = 11;
        pkmnTypes[offset+11][1] = 9;
        pkmnTypes[offset+12][0] = 11;
        pkmnTypes[offset+12][1] = 7;
        pkmnTypes[offset+13][0] = 11;
        pkmnTypes[offset+13][1] = 7;
        pkmnTypes[offset+14][0] = 11;
        pkmnTypes[offset+14][1] = 7;
        pkmnTypes[offset+15][0] = 0;
        pkmnTypes[offset+15][1] = 9;
        pkmnTypes[offset+16][0] = 0;
        pkmnTypes[offset+16][1] = 9;
        pkmnTypes[offset+17][0] = 0;
        pkmnTypes[offset+17][1] = 9;
        pkmnTypes[offset+18][0] = 0;
        pkmnTypes[offset+19][0] = 0;
        pkmnTypes[offset+20][0] = 0;
        pkmnTypes[offset+20][1] = 9;
        pkmnTypes[offset+21][0] = 0;
        pkmnTypes[offset+21][1] = 9;
        pkmnTypes[offset+22][0] = 7;
        pkmnTypes[offset+23][0] = 7;
        pkmnTypes[offset+24][0] = 3;
        pkmnTypes[offset+24][2] = 0; // lightning rod
        pkmnTypes[offset+25][0] = 3;
        pkmnTypes[offset+25][2] = 0; // lightning rod
        pkmnTypes[offset+26][0] = 8;
        pkmnTypes[offset+27][0] = 8;
        pkmnTypes[offset+28][0] = 7;
        pkmnTypes[offset+29][0] = 7;
        pkmnTypes[offset+30][0] = 7;
        pkmnTypes[offset+30][1] = 8;
        pkmnTypes[offset+31][0] = 7;
        pkmnTypes[offset+32][0] = 7;
        pkmnTypes[offset+33][0] = 7;
        pkmnTypes[offset+33][1] = 8;
        pkmnTypes[offset+34][0] = 0;
        pkmnTypes[offset+35][0] = 0;
        pkmnTypes[offset+36][0] = 1;
        pkmnTypes[offset+36][2] = 6; // flash fire
        pkmnTypes[offset+37][0] = 1;
        pkmnTypes[offset+37][2] = 6; // flash fire
        pkmnTypes[offset+38][0] = 0;
        pkmnTypes[offset+39][0] = 0;
        pkmnTypes[offset+40][0] = 7;
        pkmnTypes[offset+40][1] = 9;
        pkmnTypes[offset+41][0] = 7;
        pkmnTypes[offset+41][1] = 9;
        pkmnTypes[offset+42][0] = 4;
        pkmnTypes[offset+42][1] = 7;
        pkmnTypes[offset+43][0] = 4;
        pkmnTypes[offset+43][1] = 7;
        pkmnTypes[offset+44][0] = 4;
        pkmnTypes[offset+44][1] = 7;
        pkmnTypes[offset+45][0] = 11;
        pkmnTypes[offset+45][1] = 4;
        pkmnTypes[offset+45][2] = 7; // dry skin
        pkmnTypes[offset+46][0] = 11;
        pkmnTypes[offset+46][1] = 4;
        pkmnTypes[offset+46][2] = 7; // dry skin
        pkmnTypes[offset+47][0] = 11;
        pkmnTypes[offset+47][1] = 7;
        pkmnTypes[offset+48][0] = 11;
        pkmnTypes[offset+48][1] = 7;
        pkmnTypes[offset+49][0] = 8;
        pkmnTypes[offset+50][0] = 8;
        pkmnTypes[offset+51][0] = 0;
        pkmnTypes[offset+52][0] = 0;
        pkmnTypes[offset+53][0] = 2;
        pkmnTypes[offset+54][0] = 2;
        pkmnTypes[offset+55][0] = 6;
        pkmnTypes[offset+56][0] = 6;
        pkmnTypes[offset+57][0] = 1;
        pkmnTypes[offset+57][2] = 6; // flash fire
        pkmnTypes[offset+58][0] = 1;
        pkmnTypes[offset+58][2] = 6; // flash fire
        pkmnTypes[offset+59][0] = 2;
        pkmnTypes[offset+59][2] = 4; // water absorb
        pkmnTypes[offset+60][0] = 2;
        pkmnTypes[offset+60][2] = 4; // water absorb
        pkmnTypes[offset+61][0] = 2;
        pkmnTypes[offset+61][1] = 6;
        pkmnTypes[offset+61][2] = 4; // water absorb
        pkmnTypes[offset+62][0] = 10;
        pkmnTypes[offset+63][0] = 10;
        pkmnTypes[offset+64][0] = 10;
        pkmnTypes[offset+65][0] = 6;
        pkmnTypes[offset+66][0] = 6;
        pkmnTypes[offset+67][0] = 6;
        pkmnTypes[offset+68][0] = 4;
        pkmnTypes[offset+68][1] = 7;
        pkmnTypes[offset+69][0] = 4;
        pkmnTypes[offset+69][1] = 7;
        pkmnTypes[offset+70][0] = 4;
        pkmnTypes[offset+70][1] = 7;
        pkmnTypes[offset+71][0] = 2;
        pkmnTypes[offset+71][1] = 7;
        pkmnTypes[offset+72][0] = 2;
        pkmnTypes[offset+72][1] = 7;
        pkmnTypes[offset+73][0] = 12;
        pkmnTypes[offset+73][1] = 8;
        pkmnTypes[offset+74][0] = 12;
        pkmnTypes[offset+74][1] = 8;
        pkmnTypes[offset+75][0] = 12;
        pkmnTypes[offset+75][1] = 8;
        pkmnTypes[offset+76][0] = 1;
        pkmnTypes[offset+76][2] = 6; // flash fire
        pkmnTypes[offset+77][0] = 1;
        pkmnTypes[offset+77][2] = 6; // flash fire
        pkmnTypes[offset+78][0] = 2;
        pkmnTypes[offset+78][1] = 10;
        pkmnTypes[offset+79][0] = 2;
        pkmnTypes[offset+79][1] = 10;
        pkmnTypes[offset+80][0] = 3;
        pkmnTypes[offset+80][1] = 16;
        pkmnTypes[offset+81][0] = 3;
        pkmnTypes[offset+81][1] = 16;
        pkmnTypes[offset+82][0] = 0;
        pkmnTypes[offset+82][1] = 9;
        pkmnTypes[offset+83][0] = 0;
        pkmnTypes[offset+83][1] = 9;
        pkmnTypes[offset+84][0] = 0;
        pkmnTypes[offset+84][1] = 9;
        pkmnTypes[offset+85][0] = 2;
        pkmnTypes[offset+86][0] = 2;
        pkmnTypes[offset+86][1] = 5;
        pkmnTypes[offset+87][0] = 7;
        pkmnTypes[offset+88][0] = 7;
        pkmnTypes[offset+89][0] = 2;
        pkmnTypes[offset+90][0] = 2;
        pkmnTypes[offset+90][1] = 5;
        pkmnTypes[offset+91][0] = 13;
        pkmnTypes[offset+91][1] = 7;
        pkmnTypes[offset+91][1] = 8; // levitate
        pkmnTypes[offset+92][0] = 13;
        pkmnTypes[offset+92][1] = 7;
        pkmnTypes[offset+92][1] = 8; // levitate
        pkmnTypes[offset+93][0] = 13;
        pkmnTypes[offset+93][1] = 7;
        pkmnTypes[offset+93][1] = 8; // levitate
        pkmnTypes[offset+94][0] = 12;
        pkmnTypes[offset+94][1] = 8;
        pkmnTypes[offset+95][0] = 10;
        pkmnTypes[offset+96][0] = 10;
        pkmnTypes[offset+97][0] = 2;
        pkmnTypes[offset+98][0] = 2;
        pkmnTypes[offset+99][0] = 3;
        pkmnTypes[offset+100][0] = 3;
        pkmnTypes[offset+101][0] = 4;
        pkmnTypes[offset+101][1] = 10;
        pkmnTypes[offset+102][0] = 4;
        pkmnTypes[offset+102][1] = 10;
        pkmnTypes[offset+103][0] = 8;
        pkmnTypes[offset+104][0] = 8;
        pkmnTypes[offset+105][0] = 6;
        pkmnTypes[offset+106][0] = 6;
        pkmnTypes[offset+107][0] = 0;
        pkmnTypes[offset+108][0] = 7;
        pkmnTypes[offset+108][2] = 8; // levitate
        pkmnTypes[offset+109][0] = 7;
        pkmnTypes[offset+109][2] = 8; // levitate
        pkmnTypes[offset+110][0] = 8;
        pkmnTypes[offset+110][1] = 12;
        pkmnTypes[offset+111][0] = 8;
        pkmnTypes[offset+111][1] = 12;
        pkmnTypes[offset+112][0] = 0;
        pkmnTypes[offset+113][0] = 4;
        pkmnTypes[offset+114][0] = 0;
        pkmnTypes[offset+115][0] = 2;
        pkmnTypes[offset+116][0] = 2;
        pkmnTypes[offset+117][0] = 2;
        pkmnTypes[offset+117][2] = 0; // lightning rod
        pkmnTypes[offset+118][0] = 2;
        pkmnTypes[offset+118][2] = 0; // lightning rod
        pkmnTypes[offset+119][0] = 2;
        pkmnTypes[offset+120][0] = 2;
        pkmnTypes[offset+120][1] = 10;
        pkmnTypes[offset+121][0] = 10;
        pkmnTypes[offset+122][0] = 11;
        pkmnTypes[offset+122][1] = 9;
        pkmnTypes[offset+123][0] = 5;
        pkmnTypes[offset+123][1] = 10;
        pkmnTypes[offset+123][2] = 7; // dry skin
        pkmnTypes[offset+124][0] = 3;
        pkmnTypes[offset+125][0] = 1;
        pkmnTypes[offset+126][0] = 11;
        pkmnTypes[offset+127][0] = 0;
        pkmnTypes[offset+128][0] = 2;
        pkmnTypes[offset+129][0] = 2;
        pkmnTypes[offset+129][1] = 9;
        pkmnTypes[offset+130][0] = 2;
        pkmnTypes[offset+130][1] = 5;
        pkmnTypes[offset+130][2] = 4; // water absorb
        pkmnTypes[offset+131][0] = 0;
        pkmnTypes[offset+132][0] = 0;
        pkmnTypes[offset+133][0] = 2;
        pkmnTypes[offset+133][2] = 4; // water absorb
        pkmnTypes[offset+134][0] = 3;
        pkmnTypes[offset+134][2] = 2; // volt absorb
        pkmnTypes[offset+135][0] = 1;
        pkmnTypes[offset+135][2] = 6; // flash fire
        pkmnTypes[offset+136][0] = 0;
        pkmnTypes[offset+137][0] = 12;
        pkmnTypes[offset+137][1] = 2;
        pkmnTypes[offset+138][0] = 12;
        pkmnTypes[offset+138][1] = 2;
        pkmnTypes[offset+139][0] = 12;
        pkmnTypes[offset+139][1] = 2;
        pkmnTypes[offset+140][0] = 12;
        pkmnTypes[offset+140][1] = 2;
        pkmnTypes[offset+141][0] = 12;
        pkmnTypes[offset+141][1] = 9;
        pkmnTypes[offset+142][0] = 0;
        pkmnTypes[offset+142][2] = 9; // thick fat
        pkmnTypes[offset+143][0] = 5;
        pkmnTypes[offset+143][1] = 9;
        pkmnTypes[offset+144][0] = 3;
        pkmnTypes[offset+144][1] = 9;
        pkmnTypes[offset+144][2] = 0; // lightning rod
        pkmnTypes[offset+145][0] = 1;
        pkmnTypes[offset+145][1] = 9;
        pkmnTypes[offset+146][0] = 14;
        pkmnTypes[offset+147][0] = 14;
        pkmnTypes[offset+148][0] = 14;
        pkmnTypes[offset+148][1] = 9;
        pkmnTypes[offset+149][0] = 10;
        pkmnTypes[offset+150][0] = 10;
        pkmnTypes[offset+151][0] = 4;
        pkmnTypes[offset+152][0] = 4;
        pkmnTypes[offset+153][0] = 4;
        pkmnTypes[offset+154][0] = 1;
        pkmnTypes[offset+154][2] = 6; // flash fire
        pkmnTypes[offset+155][0] = 1;
        pkmnTypes[offset+155][2] = 6; // flash fire
        pkmnTypes[offset+156][0] = 1;
        pkmnTypes[offset+156][2] = 6; // flash fire
        pkmnTypes[offset+157][0] = 2;
        pkmnTypes[offset+158][0] = 2;
        pkmnTypes[offset+159][0] = 2;
        pkmnTypes[offset+160][0] = 0;
        pkmnTypes[offset+161][0] = 0;
        pkmnTypes[offset+162][0] = 0;
        pkmnTypes[offset+162][1] = 9;
        pkmnTypes[offset+163][0] = 0;
        pkmnTypes[offset+163][1] = 9;
        pkmnTypes[offset+164][0] = 11;
        pkmnTypes[offset+164][1] = 9;
        pkmnTypes[offset+165][0] = 11;
        pkmnTypes[offset+165][1] = 9;
        pkmnTypes[offset+166][0] = 11;
        pkmnTypes[offset+166][1] = 7;
        pkmnTypes[offset+167][0] = 11;
        pkmnTypes[offset+167][1] = 7;
        pkmnTypes[offset+168][0] = 7;
        pkmnTypes[offset+168][1] = 9;
        pkmnTypes[offset+169][0] = 2;
        pkmnTypes[offset+169][1] = 3;
        pkmnTypes[offset+169][2] = 2; // volt absorb
        pkmnTypes[offset+169][3] = 4; // water absorb
        pkmnTypes[offset+170][0] = 2;
        pkmnTypes[offset+170][1] = 3;
        pkmnTypes[offset+170][2] = 2; // volt absorb
        pkmnTypes[offset+170][3] = 4; // water absorb
        pkmnTypes[offset+171][0] = 3;
        pkmnTypes[offset+171][2] = 0; // lightning rod
        pkmnTypes[offset+172][0] = 0;
        pkmnTypes[offset+173][0] = 0;
        pkmnTypes[offset+174][0] = 0;
        pkmnTypes[offset+175][0] = 0;
        pkmnTypes[offset+175][1] = 9;
        pkmnTypes[offset+176][0] = 10;
        pkmnTypes[offset+176][1] = 9;
        pkmnTypes[offset+177][0] = 10;
        pkmnTypes[offset+177][1] = 9;
        pkmnTypes[offset+178][0] = 3;
        pkmnTypes[offset+179][0] = 3;
        pkmnTypes[offset+180][0] = 3;
        pkmnTypes[offset+181][0] = 4;
        pkmnTypes[offset+182][0] = 2;
        pkmnTypes[offset+182][2] = 9; // thick fat
        pkmnTypes[offset+183][3] = 5; // sap sipper
        pkmnTypes[offset+183][0] = 2;
        pkmnTypes[offset+183][2] = 9; // thick fat
        pkmnTypes[offset+183][3] = 5; // sap sipper
        pkmnTypes[offset+184][0] = 12;
        pkmnTypes[offset+185][0] = 2;
        pkmnTypes[offset+185][2] = 4; // water absorb
        pkmnTypes[offset+186][0] = 4;
        pkmnTypes[offset+186][1] = 9;
        pkmnTypes[offset+187][0] = 4;
        pkmnTypes[offset+187][1] = 9;
        pkmnTypes[offset+188][0] = 4;
        pkmnTypes[offset+188][1] = 9;
        pkmnTypes[offset+189][0] = 0;
        pkmnTypes[offset+190][0] = 4;
        pkmnTypes[offset+191][0] = 4;
        pkmnTypes[offset+192][0] = 11;
        pkmnTypes[offset+192][1] = 9;
        pkmnTypes[offset+193][0] = 2;
        pkmnTypes[offset+193][1] = 8;
        pkmnTypes[offset+193][2] = 4; // water absorb
        pkmnTypes[offset+194][0] = 2;
        pkmnTypes[offset+194][1] = 8;
        pkmnTypes[offset+194][2] = 4; // water absorb
        pkmnTypes[offset+195][0] = 10;
        pkmnTypes[offset+196][0] = 15;
        pkmnTypes[offset+197][0] = 15;
        pkmnTypes[offset+197][1] = 9;
        pkmnTypes[offset+198][0] = 2;
        pkmnTypes[offset+198][1] = 10;
        pkmnTypes[offset+199][0] = 13;
        pkmnTypes[offset+199][2] = 8; // levitate
        pkmnTypes[offset+200][0] = 10;
        pkmnTypes[offset+200][2] = 8; // levitate
        pkmnTypes[offset+201][0] = 10;
        pkmnTypes[offset+202][0] = 0;
        pkmnTypes[offset+202][1] = 10;
        pkmnTypes[offset+202][2] = 5; // sap sipper
        pkmnTypes[offset+203][0] = 11;
        pkmnTypes[offset+204][0] = 11;
        pkmnTypes[offset+204][1] = 16;
        pkmnTypes[offset+205][0] = 0;
        pkmnTypes[offset+206][0] = 8;
        pkmnTypes[offset+206][1] = 9;
        pkmnTypes[offset+207][0] = 16;
        pkmnTypes[offset+207][1] = 8;
        pkmnTypes[offset+208][0] = 0;
        pkmnTypes[offset+209][0] = 0;
        pkmnTypes[offset+210][0] = 2;
        pkmnTypes[offset+210][1] = 7;
        pkmnTypes[offset+211][0] = 11;
        pkmnTypes[offset+211][1] = 16;
        pkmnTypes[offset+212][0] = 11;
        pkmnTypes[offset+212][1] = 12;
        pkmnTypes[offset+213][0] = 11;
        pkmnTypes[offset+213][1] = 6;
        pkmnTypes[offset+214][0] = 15;
        pkmnTypes[offset+214][1] = 5;
        pkmnTypes[offset+215][0] = 0;
        pkmnTypes[offset+216][0] = 0;
        pkmnTypes[offset+217][0] = 1;
        pkmnTypes[offset+218][0] = 1;
        pkmnTypes[offset+218][1] = 12;
        pkmnTypes[offset+219][0] = 5;
        pkmnTypes[offset+219][1] = 8;
        pkmnTypes[offset+219][2] = 9; // thick fat
        pkmnTypes[offset+220][0] = 5;
        pkmnTypes[offset+220][1] = 8;
        pkmnTypes[offset+220][2] = 9; // thick fat
        pkmnTypes[offset+221][0] = 2;
        pkmnTypes[offset+221][1] = 12;
        pkmnTypes[offset+222][0] = 2;
        pkmnTypes[offset+223][0] = 2;
        pkmnTypes[offset+224][0] = 5;
        pkmnTypes[offset+224][1] = 9;
        pkmnTypes[offset+225][0] = 2;
        pkmnTypes[offset+225][1] = 9;
        pkmnTypes[offset+225][2] = 4; // water absorb
        pkmnTypes[offset+226][0] = 16;
        pkmnTypes[offset+226][1] = 9;
        pkmnTypes[offset+227][0] = 15;
        pkmnTypes[offset+227][1] = 1;
        pkmnTypes[offset+228][0] = 15;
        pkmnTypes[offset+228][1] = 1;
        pkmnTypes[offset+228][2] = 6; // flash fire
        pkmnTypes[offset+229][0] = 2;
        pkmnTypes[offset+229][1] = 14;
        pkmnTypes[offset+228][2] = 6; // flash fire
        pkmnTypes[offset+230][0] = 8;
        pkmnTypes[offset+231][0] = 8;
        pkmnTypes[offset+232][0] = 0;
        pkmnTypes[offset+233][0] = 0;
        pkmnTypes[offset+233][2] = 5; // sap sipper
        pkmnTypes[offset+234][0] = 0;
        pkmnTypes[offset+235][0] = 6;
        pkmnTypes[offset+236][0] = 6;
        pkmnTypes[offset+237][0] = 5;
        pkmnTypes[offset+237][1] = 10;
        pkmnTypes[offset+238][0] = 3;
        pkmnTypes[offset+239][0] = 1;
        pkmnTypes[offset+240][0] = 0;
        pkmnTypes[offset+240][2] = 6; // flash fire
        pkmnTypes[offset+241][0] = 0;
        pkmnTypes[offset+242][0] = 3;
        pkmnTypes[offset+242][2] = 2; // volt absorb
        pkmnTypes[offset+243][0] = 1;
        pkmnTypes[offset+242][2] = 6; // flash fire
        pkmnTypes[offset+244][0] = 2;
        pkmnTypes[offset+244][2] = 4; // water absorb
        pkmnTypes[offset+245][0] = 12;
        pkmnTypes[offset+245][1] = 8;
        pkmnTypes[offset+246][0] = 12;
        pkmnTypes[offset+246][1] = 8;
        pkmnTypes[offset+247][0] = 12;
        pkmnTypes[offset+247][1] = 15;
        pkmnTypes[offset+248][0] = 10;
        pkmnTypes[offset+248][1] = 9;
        pkmnTypes[offset+249][0] = 1;
        pkmnTypes[offset+249][1] = 9;
        pkmnTypes[offset+250][0] = 10;
        pkmnTypes[offset+250][1] = 4;
        pkmnTypes[offset+251][0] = 4;
        pkmnTypes[offset+252][0] = 4;
        pkmnTypes[offset+253][0] = 4;
        pkmnTypes[offset+254][0] = 1;
        pkmnTypes[offset+255][0] = 1;
        pkmnTypes[offset+255][1] = 6;
        pkmnTypes[offset+256][0] = 1;
        pkmnTypes[offset+256][1] = 6;
        pkmnTypes[offset+257][0] = 2;
        pkmnTypes[offset+258][0] = 2;
        pkmnTypes[offset+258][1] = 8;
        pkmnTypes[offset+259][0] = 2;
        pkmnTypes[offset+259][1] = 8;
        pkmnTypes[offset+260][0] = 15;
        pkmnTypes[offset+261][0] = 15;
        pkmnTypes[offset+262][0] = 0;
        pkmnTypes[offset+263][0] = 0;
        pkmnTypes[offset+264][0] = 11;
        pkmnTypes[offset+265][0] = 11;
        pkmnTypes[offset+266][0] = 11;
        pkmnTypes[offset+266][1] = 9;
        pkmnTypes[offset+267][0] = 11;
        pkmnTypes[offset+268][0] = 11;
        pkmnTypes[offset+268][1] = 7;
        pkmnTypes[offset+269][0] = 2;
        pkmnTypes[offset+269][1] = 4;
        pkmnTypes[offset+270][0] = 2;
        pkmnTypes[offset+270][1] = 4;
        pkmnTypes[offset+271][0] = 2;
        pkmnTypes[offset+271][1] = 4;
        pkmnTypes[offset+272][0] = 4;
        pkmnTypes[offset+273][0] = 4;
        pkmnTypes[offset+273][1] = 15;
        pkmnTypes[offset+274][0] = 4;
        pkmnTypes[offset+274][1] = 15;
        pkmnTypes[offset+275][0] = 0;
        pkmnTypes[offset+275][1] = 9;
        pkmnTypes[offset+276][0] = 0;
        pkmnTypes[offset+276][1] = 9;
        pkmnTypes[offset+277][0] = 2;
        pkmnTypes[offset+277][1] = 9;
        pkmnTypes[offset+278][0] = 2;
        pkmnTypes[offset+278][1] = 9;
        pkmnTypes[offset+279][0] = 10;
        pkmnTypes[offset+280][0] = 10;
        pkmnTypes[offset+281][0] = 10;
        pkmnTypes[offset+282][0] = 11;
        pkmnTypes[offset+282][1] = 2;
        pkmnTypes[offset+283][0] = 11;
        pkmnTypes[offset+283][1] = 9;
        pkmnTypes[offset+284][0] = 4;
        pkmnTypes[offset+285][0] = 4;
        pkmnTypes[offset+285][1] = 6;
        pkmnTypes[offset+286][0] = 0;
        pkmnTypes[offset+287][0] = 0;
        pkmnTypes[offset+288][0] = 0;
        pkmnTypes[offset+289][0] = 11;
        pkmnTypes[offset+289][1] = 8;
        pkmnTypes[offset+290][0] = 11;
        pkmnTypes[offset+290][1] = 9;
        pkmnTypes[offset+291][0] = 11;
        pkmnTypes[offset+291][1] = 13;
        pkmnTypes[offset+291][2] = 10; // wonder guard
        pkmnTypes[offset+292][0] = 0;
        pkmnTypes[offset+293][0] = 0;
        pkmnTypes[offset+294][0] = 0;
        pkmnTypes[offset+295][0] = 6;
        pkmnTypes[offset+295][2] = 9; // thick fat
        pkmnTypes[offset+296][0] = 6;
        pkmnTypes[offset+296][2] = 9; // thick fat
        pkmnTypes[offset+297][0] = 0;
        pkmnTypes[offset+297][2] = 9; // thick fat
        pkmnTypes[offset+297][3] = 5; // sap sipper
        pkmnTypes[offset+298][0] = 12;
        pkmnTypes[offset+299][0] = 0;
        pkmnTypes[offset+300][0] = 0;
        pkmnTypes[offset+301][0] = 15;
        pkmnTypes[offset+301][1] = 13;
        pkmnTypes[offset+302][0] = 16;
        pkmnTypes[offset+303][0] = 16;
        pkmnTypes[offset+303][1] = 12;
        pkmnTypes[offset+304][0] = 16;
        pkmnTypes[offset+304][1] = 12;
        pkmnTypes[offset+305][0] = 16;
        pkmnTypes[offset+305][1] = 12;
        pkmnTypes[offset+306][0] = 6;
        pkmnTypes[offset+306][1] = 10;
        pkmnTypes[offset+307][0] = 6;
        pkmnTypes[offset+307][1] = 10;
        pkmnTypes[offset+308][0] = 3;
        pkmnTypes[offset+308][2] = 0; // lightning rod
        pkmnTypes[offset+309][0] = 3;
        pkmnTypes[offset+308][2] = 0; // lightning rod
        pkmnTypes[offset+310][0] = 3;
        pkmnTypes[offset+311][0] = 3;
        pkmnTypes[offset+312][0] = 11;
        pkmnTypes[offset+313][0] = 11;
        pkmnTypes[offset+314][0] = 4;
        pkmnTypes[offset+314][1] = 7;
        pkmnTypes[offset+315][0] = 7;
        pkmnTypes[offset+316][0] = 7;
        pkmnTypes[offset+317][0] = 2;
        pkmnTypes[offset+317][1] = 15;
        pkmnTypes[offset+318][0] = 2;
        pkmnTypes[offset+318][1] = 15;
        pkmnTypes[offset+319][0] = 2;
        pkmnTypes[offset+320][0] = 2;
        pkmnTypes[offset+321][0] = 1;
        pkmnTypes[offset+321][1] = 8;
        pkmnTypes[offset+322][0] = 1;
        pkmnTypes[offset+322][1] = 8;
        pkmnTypes[offset+323][0] = 1;
        pkmnTypes[offset+324][0] = 10;
        pkmnTypes[offset+325][0] = 10;
        pkmnTypes[offset+326][0] = 0;
        pkmnTypes[offset+327][0] = 8;
        pkmnTypes[offset+328][0] = 8;
        pkmnTypes[offset+328][1] = 14;
        pkmnTypes[offset+328][2] = 8; // levitate
        pkmnTypes[offset+329][0] = 8;
        pkmnTypes[offset+329][1] = 14;
        pkmnTypes[offset+329][2] = 8; // levitate
        pkmnTypes[offset+330][0] = 4;
        pkmnTypes[offset+330][2] = 4; // water absorb
        pkmnTypes[offset+331][0] = 4;
        pkmnTypes[offset+331][1] = 15;
        pkmnTypes[offset+331][2] = 4; // water absorb
        pkmnTypes[offset+332][0] = 0;
        pkmnTypes[offset+332][1] = 9;
        pkmnTypes[offset+333][0] = 14;
        pkmnTypes[offset+333][1] = 9;
        pkmnTypes[offset+334][0] = 0;
        pkmnTypes[offset+335][0] = 7;
        pkmnTypes[offset+336][0] = 12;
        pkmnTypes[offset+336][1] = 10;
        pkmnTypes[offset+336][2] = 8; // levitate
        pkmnTypes[offset+337][0] = 12;
        pkmnTypes[offset+337][1] = 10;
        pkmnTypes[offset+337][2] = 8; // levitate
        pkmnTypes[offset+338][0] = 2;
        pkmnTypes[offset+338][1] = 8;
        pkmnTypes[offset+339][0] = 2;
        pkmnTypes[offset+339][1] = 8;
        pkmnTypes[offset+340][0] = 2;
        pkmnTypes[offset+341][0] = 2;
        pkmnTypes[offset+341][1] = 15;
        pkmnTypes[offset+342][0] = 8;
        pkmnTypes[offset+342][1] = 10;
        pkmnTypes[offset+342][2] = 8; // levitate
        pkmnTypes[offset+343][0] = 8;
        pkmnTypes[offset+343][1] = 10;
        pkmnTypes[offset+343][2] = 8; // levitate
        pkmnTypes[offset+344][0] = 12;
        pkmnTypes[offset+344][1] = 4;
        pkmnTypes[offset+344][2] = 3; // storm drain
        pkmnTypes[offset+345][0] = 12;
        pkmnTypes[offset+345][1] = 4;
        pkmnTypes[offset+345][2] = 3; // storm drain
        pkmnTypes[offset+346][0] = 12;
        pkmnTypes[offset+346][1] = 11;
        pkmnTypes[offset+347][0] = 12;
        pkmnTypes[offset+347][1] = 11;
        pkmnTypes[offset+348][0] = 2;
        pkmnTypes[offset+349][0] = 2;
        pkmnTypes[offset+350][0] = 0;
        pkmnTypes[offset+351][0] = 0;
        pkmnTypes[offset+352][0] = 13;
        pkmnTypes[offset+353][0] = 13;
        pkmnTypes[offset+354][0] = 13;
        pkmnTypes[offset+354][2] = 8; // levitate
        pkmnTypes[offset+355][0] = 13;
        pkmnTypes[offset+356][0] = 4;
        pkmnTypes[offset+356][1] = 9;
        pkmnTypes[offset+357][0] = 10;
        pkmnTypes[offset+357][2] = 8; // levitate
        pkmnTypes[offset+358][0] = 15;
        pkmnTypes[offset+359][0] = 10;
        pkmnTypes[offset+360][0] = 5;
        pkmnTypes[offset+361][0] = 5;
        pkmnTypes[offset+362][0] = 5;
        pkmnTypes[offset+362][1] = 2;
        pkmnTypes[offset+362][2] = 9; // thick fat
        pkmnTypes[offset+363][0] = 5;
        pkmnTypes[offset+363][1] = 2;
        pkmnTypes[offset+362][2] = 9; // thick fat
        pkmnTypes[offset+364][0] = 5;
        pkmnTypes[offset+364][1] = 2;
        pkmnTypes[offset+362][2] = 9; // thick fat
        pkmnTypes[offset+365][0] = 2;
        pkmnTypes[offset+366][0] = 2;
        pkmnTypes[offset+367][0] = 2;
        pkmnTypes[offset+368][0] = 2;
        pkmnTypes[offset+368][1] = 12;
        pkmnTypes[offset+369][0] = 2;
        pkmnTypes[offset+370][0] = 14;
        pkmnTypes[offset+371][0] = 14;
        pkmnTypes[offset+372][0] = 14;
        pkmnTypes[offset+372][1] = 9;
        pkmnTypes[offset+373][0] = 16;
        pkmnTypes[offset+373][1] = 10;
        pkmnTypes[offset+374][0] = 16;
        pkmnTypes[offset+374][1] = 10;
        pkmnTypes[offset+375][0] = 16;
        pkmnTypes[offset+375][1] = 10;
        pkmnTypes[offset+376][0] = 12;
        pkmnTypes[offset+377][0] = 5;
        pkmnTypes[offset+378][0] = 16;
        pkmnTypes[offset+379][0] = 14;
        pkmnTypes[offset+379][1] = 10;
        pkmnTypes[offset+379][2] = 8; // levitate
        pkmnTypes[offset+380][0] = 14;
        pkmnTypes[offset+380][1] = 10;
        pkmnTypes[offset+380][2] = 8; // levitate
        pkmnTypes[offset+381][0] = 2;
        pkmnTypes[offset+382][0] = 8;
        pkmnTypes[offset+383][0] = 14;
        pkmnTypes[offset+383][1] = 9;
        pkmnTypes[offset+384][0] = 16;
        pkmnTypes[offset+384][1] = 10;
        pkmnTypes[offset+385][0] = 10;
        pkmnTypes[offset+386][0] = 4;
        pkmnTypes[offset+387][0] = 4;
        pkmnTypes[offset+388][0] = 4;
        pkmnTypes[offset+388][1] = 8;
        pkmnTypes[offset+389][0] = 1;
        pkmnTypes[offset+390][0] = 1;
        pkmnTypes[offset+390][1] = 6;
        pkmnTypes[offset+391][0] = 1;
        pkmnTypes[offset+391][1] = 6;
        pkmnTypes[offset+392][0] = 2;
        pkmnTypes[offset+393][0] = 2;
        pkmnTypes[offset+394][0] = 2;
        pkmnTypes[offset+394][1] = 16;
        pkmnTypes[offset+395][0] = 0;
        pkmnTypes[offset+395][1] = 9;
        pkmnTypes[offset+396][0] = 0;
        pkmnTypes[offset+396][1] = 9;
        pkmnTypes[offset+397][0] = 0;
        pkmnTypes[offset+397][1] = 9;
        pkmnTypes[offset+398][0] = 0;
        pkmnTypes[offset+399][0] = 0;
        pkmnTypes[offset+399][1] = 2;
        pkmnTypes[offset+400][0] = 11;
        pkmnTypes[offset+401][0] = 11;
        pkmnTypes[offset+402][0] = 3;
        pkmnTypes[offset+403][0] = 3;
        pkmnTypes[offset+404][0] = 3;
        pkmnTypes[offset+405][0] = 4;
        pkmnTypes[offset+405][1] = 7;
        pkmnTypes[offset+406][0] = 4;
        pkmnTypes[offset+406][1] = 7;
        pkmnTypes[offset+407][0] = 12;
        pkmnTypes[offset+408][0] = 12;
        pkmnTypes[offset+409][0] = 12;
        pkmnTypes[offset+409][1] = 16;
        pkmnTypes[offset+410][0] = 12;
        pkmnTypes[offset+410][1] = 16;
        pkmnTypes[offset+411][0] = 11;
        pkmnTypes[offset+412][0] = 11; // wormadam leaf
        pkmnTypes[offset+412][1] = 4;
        offset++;
        pkmnTypes[offset+412][0] = 11; // wormadam sand
        pkmnTypes[offset+412][1] = 8;
        offset++;
        pkmnTypes[offset+412][0] = 11; // wormadam trash
        pkmnTypes[offset+412][1] = 16;
        pkmnTypes[offset+413][0] = 11;
        pkmnTypes[offset+413][1] = 9;
        pkmnTypes[offset+414][0] = 11;
        pkmnTypes[offset+414][1] = 9;
        pkmnTypes[offset+415][0] = 11;
        pkmnTypes[offset+415][1] = 9;
        pkmnTypes[offset+416][0] = 3;
        pkmnTypes[offset+416][2] = 3; // volt absorb
        pkmnTypes[offset+417][0] = 2;
        pkmnTypes[offset+418][0] = 2;
        pkmnTypes[offset+419][0] = 4;
        pkmnTypes[offset+420][0] = 4;
        pkmnTypes[offset+421][0] = 2;
        pkmnTypes[offset+421][2] = 3; // storm drain
        pkmnTypes[offset+422][0] = 2;
        pkmnTypes[offset+422][1] = 8;
        pkmnTypes[offset+422][2] = 3; // storm drain
        pkmnTypes[offset+423][0] = 0;
        pkmnTypes[offset+424][0] = 13;
        pkmnTypes[offset+424][1] = 9;
        pkmnTypes[offset+425][0] = 13;
        pkmnTypes[offset+425][1] = 9;
        pkmnTypes[offset+426][0] = 0;
        pkmnTypes[offset+427][0] = 0;
        pkmnTypes[offset+428][0] = 13;
        pkmnTypes[offset+428][2] = 8; // levitate
        pkmnTypes[offset+429][0] = 15;
        pkmnTypes[offset+429][1] = 9;
        pkmnTypes[offset+430][0] = 0;
        pkmnTypes[offset+431][0] = 0;
        pkmnTypes[offset+432][0] = 10;
        pkmnTypes[offset+432][2] = 8; // levitate
        pkmnTypes[offset+433][0] = 7;
        pkmnTypes[offset+433][1] = 15;
        pkmnTypes[offset+434][0] = 7;
        pkmnTypes[offset+434][1] = 15;
        pkmnTypes[offset+434][2] = 8; // levitate
        pkmnTypes[offset+434][2] = 11; // heat proof
        pkmnTypes[offset+435][0] = 16;
        pkmnTypes[offset+435][1] = 10;
        pkmnTypes[offset+435][2] = 8; // levitate
        pkmnTypes[offset+435][2] = 11; // heat proof
        pkmnTypes[offset+436][0] = 16;
        pkmnTypes[offset+436][1] = 10;
        pkmnTypes[offset+437][0] = 12;
        pkmnTypes[offset+438][0] = 10;
        pkmnTypes[offset+439][0] = 0;
        pkmnTypes[offset+440][0] = 0;
        pkmnTypes[offset+440][1] = 9;
        pkmnTypes[offset+441][0] = 13;
        pkmnTypes[offset+441][1] = 15;
        pkmnTypes[offset+442][0] = 14;
        pkmnTypes[offset+442][1] = 8;
        pkmnTypes[offset+443][0] = 14;
        pkmnTypes[offset+443][1] = 8;
        pkmnTypes[offset+444][0] = 14;
        pkmnTypes[offset+444][1] = 8;
        pkmnTypes[offset+445][0] = 0;
        pkmnTypes[offset+445][2] = 9; // thick fat
        pkmnTypes[offset+446][0] = 6;
        pkmnTypes[offset+447][0] = 6;
        pkmnTypes[offset+447][1] = 16;
        pkmnTypes[offset+448][0] = 8;
        pkmnTypes[offset+449][0] = 8;
        pkmnTypes[offset+450][0] = 7;
        pkmnTypes[offset+450][1] = 11;
        pkmnTypes[offset+451][0] = 7;
        pkmnTypes[offset+451][1] = 15;
        pkmnTypes[offset+452][0] = 7;
        pkmnTypes[offset+452][1] = 6;
        pkmnTypes[offset+452][2] = 7; // dry skin
        pkmnTypes[offset+453][0] = 7;
        pkmnTypes[offset+453][1] = 6;
        pkmnTypes[offset+453][2] = 7; // dry skin
        pkmnTypes[offset+454][0] = 4;
        pkmnTypes[offset+454][2] = 8; // levitate
        pkmnTypes[offset+455][0] = 2;
        pkmnTypes[offset+455][2] = 3; // storm drain
        pkmnTypes[offset+456][0] = 2;
        pkmnTypes[offset+456][2] = 3; // storm drain
        pkmnTypes[offset+457][0] = 2;
        pkmnTypes[offset+457][1] = 9;
        pkmnTypes[offset+457][2] = 4; // water absorb
        pkmnTypes[offset+458][0] = 4;
        pkmnTypes[offset+458][1] = 5;
        pkmnTypes[offset+459][0] = 4;
        pkmnTypes[offset+459][1] = 5;
        pkmnTypes[offset+460][0] = 15;
        pkmnTypes[offset+460][1] = 5;
        pkmnTypes[offset+461][0] = 3;
        pkmnTypes[offset+461][1] = 16;
        pkmnTypes[offset+462][0] = 0;
        pkmnTypes[offset+463][0] = 8;
        pkmnTypes[offset+463][1] = 12;
        pkmnTypes[offset+464][0] = 4;
        pkmnTypes[offset+465][0] = 3;
        pkmnTypes[offset+466][0] = 1;
        pkmnTypes[offset+466][2] = 1; // motor drive
        pkmnTypes[offset+467][0] = 0;
        pkmnTypes[offset+467][1] = 9;
        pkmnTypes[offset+468][0] = 11;
        pkmnTypes[offset+468][1] = 9;
        pkmnTypes[offset+469][0] = 4;
        pkmnTypes[offset+470][0] = 5;
        pkmnTypes[offset+471][0] = 8;
        pkmnTypes[offset+471][1] = 9;
        pkmnTypes[offset+472][0] = 5;
        pkmnTypes[offset+472][1] = 8;
        pkmnTypes[offset+472][2] = 9; // thick fat
        pkmnTypes[offset+473][0] = 0;
        pkmnTypes[offset+474][0] = 10;
        pkmnTypes[offset+474][1] = 6;
        pkmnTypes[offset+475][0] = 12;
        pkmnTypes[offset+475][1] = 16;
        pkmnTypes[offset+476][0] = 13;
        pkmnTypes[offset+477][0] = 5;
        pkmnTypes[offset+477][1] = 13;
        pkmnTypes[offset+478][0] = 3; // rotom normal
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        offset++;
        pkmnTypes[offset+478][0] = 1; // rotom heat
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        offset++;
        pkmnTypes[offset+478][0] = 2; // rotom wash
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        offset++;
        pkmnTypes[offset+478][0] = 5; // rotom frost
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        offset++;
        pkmnTypes[offset+478][0] = 9; // rotom fan
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        offset++;
        pkmnTypes[offset+478][0] = 4; // rotom mow
        pkmnTypes[offset+478][1] = 13;
        pkmnTypes[offset+478][2] = 8; // levitate
        pkmnTypes[offset+479][0] = 10;
        pkmnTypes[offset+479][2] = 8; // levitate
        pkmnTypes[offset+480][0] = 10;
        pkmnTypes[offset+480][2] = 8; // levitate
        pkmnTypes[offset+481][0] = 10;
        pkmnTypes[offset+481][2] = 8; // levitate
        pkmnTypes[offset+482][0] = 16;
        pkmnTypes[offset+482][1] = 14;
        pkmnTypes[offset+483][0] = 2;
        pkmnTypes[offset+483][1] = 14;
        pkmnTypes[offset+484][0] = 1;
        pkmnTypes[offset+484][1] = 16;
        pkmnTypes[offset+484][2] = 6; // flash fire
        pkmnTypes[offset+485][0] = 0;
        pkmnTypes[offset+486][0] = 13; // giratina altered
        pkmnTypes[offset+486][1] = 14;
        offset++;
        pkmnTypes[offset+486][0] = 13; // giratina origin
        pkmnTypes[offset+486][1] = 14;
        pkmnTypes[offset+486][2] = 8; // levitate
        pkmnTypes[offset+487][0] = 10;
        pkmnTypes[offset+487][2] = 8; // levitate
        pkmnTypes[offset+488][0] = 2;
        pkmnTypes[offset+489][0] = 2;
        pkmnTypes[offset+490][0] = 15;
        pkmnTypes[offset+491][0] = 4; // shaymin land
        offset++;
        pkmnTypes[offset+491][0] = 4; // shaymin sky
        pkmnTypes[offset+491][1] = 9;
        pkmnTypes[offset+492][0] = 0; // arceus normal
        offset++;
        pkmnTypes[offset+492][0] = 1; // arceus fire
        offset++;
        pkmnTypes[offset+492][0] = 2; // arceus water
        offset++;
        pkmnTypes[offset+492][0] = 3; // arceus electric
        offset++;
        pkmnTypes[offset+492][0] = 4; // arceus grass
        offset++;
        pkmnTypes[offset+492][0] = 5; // arceus ice
        offset++;
        pkmnTypes[offset+492][0] = 6; // arceus fighting
        offset++;
        pkmnTypes[offset+492][0] = 7; // arceus poison
        offset++;
        pkmnTypes[offset+492][0] = 8; // arceus ground
        offset++;
        pkmnTypes[offset+492][0] = 9; // arceus flying
        offset++;
        pkmnTypes[offset+492][0] = 10; // arceus psychic
        offset++;
        pkmnTypes[offset+492][0] = 11; // arceus bug
        offset++;
        pkmnTypes[offset+492][0] = 12; // arceus rock
        offset++;
        pkmnTypes[offset+492][0] = 13; // arceus ghost
        offset++;
        pkmnTypes[offset+492][0] = 14; // arceus dragon
        offset++;
        pkmnTypes[offset+492][0] = 15; // arceus dark
        offset++;
        pkmnTypes[offset+492][0] = 16; // arceus steel
        pkmnTypes[offset+493][0] = 10;
        pkmnTypes[offset+493][1] = 1;
        pkmnTypes[offset+494][0] = 4;
        pkmnTypes[offset+495][0] = 4;
        pkmnTypes[offset+496][0] = 4;
        pkmnTypes[offset+497][0] = 1;
        pkmnTypes[offset+498][0] = 1;
        pkmnTypes[offset+498][1] = 6;
        pkmnTypes[offset+499][0] = 1;
        pkmnTypes[offset+499][1] = 6;
        pkmnTypes[offset+500][0] = 2;
        pkmnTypes[offset+501][0] = 2;
        pkmnTypes[offset+502][0] = 2;
        pkmnTypes[offset+503][0] = 0;
        pkmnTypes[offset+504][0] = 0;
        pkmnTypes[offset+505][0] = 0;
        pkmnTypes[offset+506][0] = 0;
        pkmnTypes[offset+507][0] = 0;
        pkmnTypes[offset+508][0] = 15;
        pkmnTypes[offset+509][0] = 15;
        pkmnTypes[offset+510][0] = 4;
        pkmnTypes[offset+511][0] = 4;
        pkmnTypes[offset+512][0] = 1;
        pkmnTypes[offset+513][0] = 1;
        pkmnTypes[offset+514][0] = 2;
        pkmnTypes[offset+515][0] = 2;
        pkmnTypes[offset+516][0] = 10;
        pkmnTypes[offset+517][0] = 10;
        pkmnTypes[offset+518][0] = 0;
        pkmnTypes[offset+518][1] = 9;
        pkmnTypes[offset+519][0] = 0;
        pkmnTypes[offset+519][1] = 9;
        pkmnTypes[offset+520][0] = 0;
        pkmnTypes[offset+520][1] = 9;
        pkmnTypes[offset+521][0] = 3;
        pkmnTypes[offset+521][2] = 0; // lightning rod (and motor drive)
        pkmnTypes[offset+521][3] = 5; // sap sipper
        pkmnTypes[offset+522][0] = 3;
        pkmnTypes[offset+522][2] = 0; // lightning rod (and motor drive)
        pkmnTypes[offset+522][3] = 5; // sap sipper
        pkmnTypes[offset+523][0] = 12;
        pkmnTypes[offset+524][0] = 12;
        pkmnTypes[offset+525][0] = 12;
        pkmnTypes[offset+526][0] = 10;
        pkmnTypes[offset+526][1] = 9;
        pkmnTypes[offset+527][0] = 10;
        pkmnTypes[offset+527][1] = 9;
        pkmnTypes[offset+528][0] = 8;
        pkmnTypes[offset+529][0] = 8;
        pkmnTypes[offset+529][1] = 16;
        pkmnTypes[offset+530][0] = 0;
        pkmnTypes[offset+531][0] = 6;
        pkmnTypes[offset+532][0] = 6;
        pkmnTypes[offset+533][0] = 6;
        pkmnTypes[offset+534][0] = 2;
        pkmnTypes[offset+534][2] = 4; // water absorb
        pkmnTypes[offset+535][0] = 2;
        pkmnTypes[offset+535][1] = 8;
        pkmnTypes[offset+535][2] = 4; // water absorb
        pkmnTypes[offset+536][0] = 2;
        pkmnTypes[offset+536][1] = 8;
        pkmnTypes[offset+536][2] = 4; // water absorb
        pkmnTypes[offset+537][0] = 6;
        pkmnTypes[offset+538][0] = 6;
        pkmnTypes[offset+539][0] = 11;
        pkmnTypes[offset+539][1] = 4;
        pkmnTypes[offset+540][0] = 11;
        pkmnTypes[offset+540][1] = 4;
        pkmnTypes[offset+541][0] = 11;
        pkmnTypes[offset+541][1] = 4;
        pkmnTypes[offset+542][0] = 11;
        pkmnTypes[offset+542][1] = 7;
        pkmnTypes[offset+543][0] = 11;
        pkmnTypes[offset+543][1] = 7;
        pkmnTypes[offset+544][0] = 11;
        pkmnTypes[offset+544][1] = 7;
        pkmnTypes[offset+545][0] = 4;
        pkmnTypes[offset+546][0] = 4;
        pkmnTypes[offset+547][0] = 4;
        pkmnTypes[offset+548][0] = 4;
        pkmnTypes[offset+549][0] = 2;
        pkmnTypes[offset+550][0] = 8;
        pkmnTypes[offset+550][1] = 15;
        pkmnTypes[offset+551][0] = 8;
        pkmnTypes[offset+551][1] = 15;
        pkmnTypes[offset+552][0] = 8;
        pkmnTypes[offset+552][1] = 15;
        pkmnTypes[offset+553][0] = 1;
        pkmnTypes[offset+554][0] = 1;
        pkmnTypes[offset+555][0] = 4;
        pkmnTypes[offset+555][2] = 4; // water absorb (and storm drain)
        pkmnTypes[offset+556][0] = 11;
        pkmnTypes[offset+556][1] = 12;
        pkmnTypes[offset+557][0] = 11;
        pkmnTypes[offset+557][1] = 12;
        pkmnTypes[offset+558][0] = 15;
        pkmnTypes[offset+558][1] = 6;
        pkmnTypes[offset+559][0] = 15;
        pkmnTypes[offset+559][1] = 6;
        pkmnTypes[offset+560][0] = 10;
        pkmnTypes[offset+560][1] = 9;
        pkmnTypes[offset+561][0] = 13;
        pkmnTypes[offset+562][0] = 13;
        pkmnTypes[offset+563][0] = 2;
        pkmnTypes[offset+563][1] = 12;
        pkmnTypes[offset+564][0] = 2;
        pkmnTypes[offset+564][1] = 12;
        pkmnTypes[offset+565][0] = 12;
        pkmnTypes[offset+565][1] = 9;
        pkmnTypes[offset+566][0] = 12;
        pkmnTypes[offset+566][1] = 9;
        pkmnTypes[offset+567][0] = 7;
        pkmnTypes[offset+568][0] = 7;
        pkmnTypes[offset+569][0] = 15;
        pkmnTypes[offset+570][0] = 15;
        pkmnTypes[offset+571][0] = 0;
        pkmnTypes[offset+572][0] = 0;
        pkmnTypes[offset+573][0] = 10;
        pkmnTypes[offset+574][0] = 10;
        pkmnTypes[offset+575][0] = 10;
        pkmnTypes[offset+576][0] = 10;
        pkmnTypes[offset+577][0] = 10;
        pkmnTypes[offset+578][0] = 10;
        pkmnTypes[offset+579][0] = 2;
        pkmnTypes[offset+579][1] = 9;
        pkmnTypes[offset+580][0] = 2;
        pkmnTypes[offset+580][1] = 9;
        pkmnTypes[offset+581][0] = 5;
        pkmnTypes[offset+582][0] = 5;
        pkmnTypes[offset+583][0] = 5;
        pkmnTypes[offset+584][0] = 0;
        pkmnTypes[offset+584][1] = 4;
        pkmnTypes[offset+584][2] = 5; // sap sipper
        pkmnTypes[offset+585][0] = 0;
        pkmnTypes[offset+585][1] = 4;
        pkmnTypes[offset+585][2] = 5; // sap sipper
        pkmnTypes[offset+586][0] = 3;
        pkmnTypes[offset+586][1] = 9;
        pkmnTypes[offset+586][2] = 1; // motor drive
        pkmnTypes[offset+587][0] = 11;
        pkmnTypes[offset+588][0] = 11;
        pkmnTypes[offset+588][1] = 16;
        pkmnTypes[offset+589][0] = 4;
        pkmnTypes[offset+589][1] = 7;
        pkmnTypes[offset+590][0] = 4;
        pkmnTypes[offset+590][1] = 7;
        pkmnTypes[offset+591][0] = 2;
        pkmnTypes[offset+591][1] = 13;
        pkmnTypes[offset+591][2] = 4; // water absorb
        pkmnTypes[offset+592][0] = 2;
        pkmnTypes[offset+592][1] = 13;
        pkmnTypes[offset+592][2] = 4; // water absorb
        pkmnTypes[offset+593][0] = 2;
        pkmnTypes[offset+594][0] = 11;
        pkmnTypes[offset+594][1] = 3;
        pkmnTypes[offset+595][0] = 11;
        pkmnTypes[offset+595][1] = 3;
        pkmnTypes[offset+596][0] = 4;
        pkmnTypes[offset+596][1] = 16;
        pkmnTypes[offset+597][0] = 4;
        pkmnTypes[offset+597][1] = 16;
        pkmnTypes[offset+598][0] = 16;
        pkmnTypes[offset+599][0] = 16;
        pkmnTypes[offset+600][0] = 16;
        pkmnTypes[offset+601][0] = 3;
        pkmnTypes[offset+601][2] = 8; // levitate
        pkmnTypes[offset+602][0] = 3;
        pkmnTypes[offset+602][2] = 8; // levitate
        pkmnTypes[offset+603][0] = 3;
        pkmnTypes[offset+603][2] = 8; // levitate
        pkmnTypes[offset+604][0] = 10;
        pkmnTypes[offset+605][0] = 10;
        pkmnTypes[offset+606][0] = 13;
        pkmnTypes[offset+606][1] = 1;
        pkmnTypes[offset+606][2] = 6; // flash fire
        pkmnTypes[offset+607][0] = 13;
        pkmnTypes[offset+607][1] = 1;
        pkmnTypes[offset+606][2] = 6; // flash fire
        pkmnTypes[offset+608][0] = 13;
        pkmnTypes[offset+608][1] = 1;
        pkmnTypes[offset+606][2] = 6; // flash fire
        pkmnTypes[offset+609][0] = 14;
        pkmnTypes[offset+610][0] = 14;
        pkmnTypes[offset+611][0] = 14;
        pkmnTypes[offset+612][0] = 5;
        pkmnTypes[offset+613][0] = 5;
        pkmnTypes[offset+614][0] = 5;
        pkmnTypes[offset+615][0] = 11;
        pkmnTypes[offset+615][2] = 8; // levitate
        pkmnTypes[offset+616][0] = 11;
        pkmnTypes[offset+617][0] = 8;
        pkmnTypes[offset+617][1] = 3;
        pkmnTypes[offset+618][0] = 6;
        pkmnTypes[offset+619][0] = 6;
        pkmnTypes[offset+620][0] = 14;
        pkmnTypes[offset+621][0] = 8;
        pkmnTypes[offset+621][1] = 13;
        pkmnTypes[offset+622][0] = 8;
        pkmnTypes[offset+622][1] = 13;
        pkmnTypes[offset+623][0] = 15;
        pkmnTypes[offset+623][1] = 16;
        pkmnTypes[offset+624][0] = 15;
        pkmnTypes[offset+624][1] = 16;
        pkmnTypes[offset+625][0] = 0;
        pkmnTypes[offset+625][2] = 5; // sap sipper
        pkmnTypes[offset+626][0] = 0;
        pkmnTypes[offset+626][1] = 9;
        pkmnTypes[offset+627][0] = 0;
        pkmnTypes[offset+627][1] = 9;
        pkmnTypes[offset+628][0] = 15;
        pkmnTypes[offset+628][1] = 9;
        pkmnTypes[offset+629][0] = 15;
        pkmnTypes[offset+629][1] = 9;
        pkmnTypes[offset+630][0] = 1;
        pkmnTypes[offset+630][2] = 6; // flash fire
        pkmnTypes[offset+631][0] = 11;
        pkmnTypes[offset+631][1] = 16;
        pkmnTypes[offset+632][0] = 15;
        pkmnTypes[offset+632][1] = 14;
        pkmnTypes[offset+633][0] = 15;
        pkmnTypes[offset+633][1] = 14;
        pkmnTypes[offset+634][0] = 15;
        pkmnTypes[offset+634][1] = 14;
        pkmnTypes[offset+634][2] = 8; // levitate
        pkmnTypes[offset+635][1] = 1;
        pkmnTypes[offset+636][0] = 11;
        pkmnTypes[offset+636][1] = 1;
        pkmnTypes[offset+637][0] = 16;
        pkmnTypes[offset+637][1] = 6;
        pkmnTypes[offset+638][0] = 12;
        pkmnTypes[offset+638][1] = 6;
        pkmnTypes[offset+639][0] = 4;
        pkmnTypes[offset+639][1] = 6;
        pkmnTypes[offset+640][0] = 9;
        pkmnTypes[offset+641][0] = 3;
        pkmnTypes[offset+641][1] = 9;
        pkmnTypes[offset+642][0] = 14;
        pkmnTypes[offset+642][1] = 1;
        pkmnTypes[offset+643][0] = 14;
        pkmnTypes[offset+643][1] = 3;
        pkmnTypes[offset+644][0] = 8;
        pkmnTypes[offset+644][1] = 9;
        pkmnTypes[offset+645][0] = 14;
        pkmnTypes[offset+645][1] = 5;
        pkmnTypes[offset+646][0] = 2;
        pkmnTypes[offset+646][1] = 6;
        pkmnTypes[offset+647][0] = 0;
        pkmnTypes[offset+647][1] = 10;
        pkmnTypes[offset+648][0] = 11;
        pkmnTypes[offset+648][1] = 16;        
    }
    
    public int[] CalcOff(int type){
        int [] offenseMult = new int[17];
        
        for (int i = 0; i < 17; i++){
            offenseMult[i] = 0;
        }
        
        switch (type){                       
            case 0:// normal
                offenseMult[12] --;
                offenseMult[13] --;
                offenseMult[16] --;
                break;
            case 1:// fire
                offenseMult[1] --;
                offenseMult[2] --;
                offenseMult[4] += 2;
                offenseMult[5] += 2;
                offenseMult[11] += 2;
                offenseMult[12] --;
                offenseMult[14] --;
                offenseMult[16] += 2;
                break;
            case 2:// water
                offenseMult[1] += 2;
                offenseMult[2] --;
                offenseMult[4] --;
                offenseMult[8] += 2;
                offenseMult[12] += 2;
                offenseMult[14] --;
                break;
            case 3:// electric
                offenseMult[2] += 2;
                offenseMult[3] --;
                offenseMult[4] --;
                offenseMult[8] --;
                offenseMult[9] += 2;
                offenseMult[14] --;
                break;
            case 4:// grass
                offenseMult[1] --;
                offenseMult[2] += 2;
                offenseMult[4] --;
                offenseMult[7] --;
                offenseMult[8] += 2;
                offenseMult[9] --;
                offenseMult[11] --;
                offenseMult[12] += 2;
                offenseMult[14] --;
                offenseMult[16] --;
                break;
            case 5:// ice
                offenseMult[1] --;
                offenseMult[2] --;
                offenseMult[4] += 2;
                offenseMult[5] --;
                offenseMult[8] += 2;
                offenseMult[9] += 2;
                offenseMult[14] += 2;
                break;
            case 6:// fighting
                offenseMult[0] += 2;
                offenseMult[5] += 2;
                offenseMult[7] --;
                offenseMult[9] --;
                offenseMult[10] --;
                offenseMult[11] --;
                offenseMult[12] += 2;
                offenseMult[13] --;
                offenseMult[15] += 2;
                offenseMult[16] += 2;
                break;
            case 7:// poison
                offenseMult[4] += 2;
                offenseMult[7] --;
                offenseMult[8] --;
                offenseMult[12] --;
                offenseMult[13] --;
                offenseMult[16] --;
                break;
            case 8:// ground
                offenseMult[1] += 2;
                offenseMult[3] += 2;
                offenseMult[4] --;
                offenseMult[7] += 2;
                offenseMult[9] --;
                offenseMult[11] --;
                offenseMult[12] += 2;
                offenseMult[16] += 2;
                break;
            case 9:// flying
                offenseMult[3] --;
                offenseMult[4] += 2;
                offenseMult[6] += 2;
                offenseMult[11] += 2;
                offenseMult[12] --;
                offenseMult[16] --;
                break;
            case 10:// psychic
                offenseMult[6] += 2;
                offenseMult[7] += 2;
                offenseMult[10] --;
                offenseMult[15] --;
                offenseMult[16] --;
                break;
            case 11:// bug
                offenseMult[1] --;
                offenseMult[4] += 2;
                offenseMult[6] --;
                offenseMult[9] --;
                offenseMult[10] += 2;
                offenseMult[13] --;
                offenseMult[15] += 2;
                offenseMult[16] --;
                break;
            case 12:// rock
                offenseMult[1] += 2;
                offenseMult[5] += 2;
                offenseMult[6] --;
                offenseMult[8] --;
                offenseMult[9] += 2;
                offenseMult[11] += 2;
                offenseMult[16] --;
                break;
            case 13://ghost
                offenseMult[0] --;
                offenseMult[10] += 2;
                offenseMult[13] += 2;
                offenseMult[15] --;
                offenseMult[16] --;
                break;
            case 14:// dragon
                offenseMult[14] += 2;
                offenseMult[16] --;
                break;
            case 15:// dark
                offenseMult[6] --;
                offenseMult[10] += 2;
                offenseMult[13] += 2;
                offenseMult[15] --;
                offenseMult[16] --;
                break;
            case 16://steel
                offenseMult[1] --;
                offenseMult[2] --;
                offenseMult[3] --;
                offenseMult[5] += 2;
                offenseMult[12] += 2;
                offenseMult[16] --;
                break;
        }
        return offenseMult;
    }
    
    public int[] CalcDef(int type, int abil){
        int [] defenseMult = new int[17];
        
        for (int i = 0; i < 17; i++){
            defenseMult[i] = 0;
        }
        
        // For defense, take abilities into account (maybe)
        if (abil > 1){// 0 and 1 are types, 2 and 3 are abilities
            System.out.println("Where getting the ability for index "+type);
            if (type == 0 || type == 1 || type == 2){// l rod, m drive, v absorb
                defenseMult[3] += 3;
            }
            else if (type == 3 || type == 4){// s drain, w absorb
                defenseMult[2] += 3;
            }
            else if (type == 5){// sap sipper
                defenseMult[4] += 3;
            }
            else if (type == 6){// flash fire
                defenseMult[1] += 3;
            }
            else if (type == 8){// levitate
                defenseMult[8] += 3;
            }
            else if (type == 10){// wonder guard (assumed to only be on Shedinja)
                // don't double up on immunities
                defenseMult[2] += 3;
                defenseMult[3] += 3;
                defenseMult[4] += 3;
                defenseMult[5] += 3;
                defenseMult[7] += 3;
                defenseMult[8] += 3;
                defenseMult[10] += 3;
                defenseMult[11] += 3;
                defenseMult[14] += 3;
                defenseMult[16] += 3;
            }
            else if (type == 7){// dry skin
                defenseMult[1] --;
                defenseMult[2] += 3;
            }
            else if (type == 9){// thick fat
                defenseMult[1] += 2;
                defenseMult[5] += 2;
            }
            else if (type == 11){// heat proof
                defenseMult[1] += 2;
            }
        }
        else{
            switch (type){                       
                case 0:// normal
                    defenseMult[6] --;
                    defenseMult[13] += 3;
                    break;
                case 1:// fire
                    defenseMult[1] += 2;
                    defenseMult[2] --;
                    defenseMult[4] += 2;
                    defenseMult[5] += 2;
                    defenseMult[8] --;
                    defenseMult[11] += 2;
                    defenseMult[12] --;
                    defenseMult[16] += 2;
                    break;
                case 2://water
                    defenseMult[1] += 2;
                    defenseMult[2] += 2;
                    defenseMult[3] --;
                    defenseMult[4] --;
                    defenseMult[5] += 2;
                    defenseMult[16] += 2;
                    break;
                case 3://electric
                    defenseMult[3] += 2;
                    defenseMult[8] --;
                    defenseMult[9] += 2;
                    defenseMult[16] += 2;
                    break;
                case 4://grass
                    defenseMult[1] --;
                    defenseMult[2] += 2;
                    defenseMult[3] += 2;
                    defenseMult[4] += 2;
                    defenseMult[5] --;
                    defenseMult[7] --;
                    defenseMult[8] +=2;
                    defenseMult[9] --;
                    defenseMult[11] --;
                    break;
                case 5://ice
                    defenseMult[1] --;
                    defenseMult[5] += 2;
                    defenseMult[6] --;
                    defenseMult[12] --;
                    defenseMult[16] --;
                    break;
                case 6://fighting
                    defenseMult[9] --;
                    defenseMult[10] --;
                    defenseMult[11] += 2;
                    defenseMult[12] += 2;
                    defenseMult[15] += 2;
                    break;
                case 7://poison
                    defenseMult[4] += 2;
                    defenseMult[6] += 2;
                    defenseMult[7] += 2;
                    defenseMult[8] --;
                    defenseMult[10] --;
                    break;
                case 8://ground
                    defenseMult[2] --;
                    defenseMult[3] += 3;
                    defenseMult[4] --;
                    defenseMult[5] --;
                    defenseMult[7] += 2;
                    defenseMult[12] += 2;
                    break;
                case 9://flying
                    defenseMult[3] --;
                    defenseMult[4] += 2;
                    defenseMult[5] --;
                    defenseMult[6] += 2;
                    defenseMult[8] += 3;
                    defenseMult[11] += 2;
                    defenseMult[12] --;
                    break;
                case 10://psychic
                    defenseMult[6] += 2;
                    defenseMult[10] += 2;
                    defenseMult[11] --;
                    defenseMult[13] --;
                    defenseMult[15] --;
                    break;
                case 11://bug
                    defenseMult[1] --;
                    defenseMult[4] += 2;
                    defenseMult[6] += 2;
                    defenseMult[8] += 2;
                    defenseMult[9] --;
                    defenseMult[12] --;
                    break;
                case 12://rock
                    defenseMult[0] += 2;
                    defenseMult[1] += 2;
                    defenseMult[2] --;
                    defenseMult[4] --;
                    defenseMult[6] --;
                    defenseMult[7] += 2;
                    defenseMult[8] --;
                    defenseMult[9] += 2;
                    defenseMult[16] --;
                    break;
                case 13://ghost
                    defenseMult[0] += 3;
                    defenseMult[6] += 3;
                    defenseMult[7] += 2;
                    defenseMult[11] += 2;
                    defenseMult[13] --;
                    defenseMult[15] --;
                    break;
                case 14://dragon
                    defenseMult[1] += 2;
                    defenseMult[2] += 2;
                    defenseMult[3] += 2;
                    defenseMult[4] += 2;
                    defenseMult[5] --;
                    defenseMult[14] --;
                    break;
                case 15://dark
                    defenseMult[6] --;
                    defenseMult[10] += 3;
                    defenseMult[11] --;
                    defenseMult[13] += 2;
                    defenseMult[15] += 2;
                    break;
                case 16://steel
                    defenseMult[0] += 2;
                    defenseMult[1] --;
                    defenseMult[4] += 2;
                    defenseMult[5] += 2;
                    defenseMult[6] --;
                    defenseMult[7] += 3;
                    defenseMult[8] --;
                    defenseMult[9] += 2;
                    defenseMult[10] += 2;
                    defenseMult[11] += 2;
                    defenseMult[12] += 2;
                    defenseMult[13] += 2;
                    defenseMult[14] += 2;
                    defenseMult[15] += 2;
                    defenseMult[16] += 2;
                    break;
                default:
                    break;
            }
        }
        return defenseMult;
    }
    
    public int TypeToInt(String type){
        for (int i = 0; i < 17; i++){
            if (type.toUpperCase().compareTo(expandedTypes[i]) == 0){
                return i;
            }
        }
        return 17;
    }
    
    public String TypeToString(int index){
        if (index > 16){
            return "???";
        }
        return expandedTypes[index];
    }
    
    public String GetStringTypeByDexNum (int index, int oneortwo){
        int typenum = pkmnTypes[index][oneortwo];
        return TypeToString(typenum);
    }
    
    public int GetIntTypeByDexNum (int index, int oneortwo){
        int typenum = pkmnTypes[index][oneortwo];
        return typenum;
    }
    
    public Color GetScoreColor(int score){
        Color retColor = goodColor;
        if (score == 0){
            retColor = zeroColor;
        }
        else if (score < 0){
            retColor = badColor;
        }
        else if (score < 4){
            retColor = okayColor;
        }
        else{
            retColor = goodColor;
        }
        
        return retColor;        
    }
    
    public Color GetCountColor(int row, int count){
        Color retColor = null;
        
        if (row == 0){
            if (count == 0){
                retColor = zeroColor;
            }
            else{
                retColor = goodColor;
            }
        }
        else if (row == 1 || row == 2){// Resistence rows
            if (count == 0){
                retColor = zeroColor;
            }
            else if (count < 3){
                retColor = okayColor;
            }
            else{
                retColor = goodColor;
            }
        }
        else if (row == 3){// neutral row
            if (count == 0){
                retColor = zeroColor;
            }
            else{
                retColor = okayColor;
            }
        }
        else if (row == 4){// the 2x row
            if (count == 0){
                retColor = goodColor;
            }
            else if (count < 3){
                retColor = zeroColor;
            }
            else{
                retColor = badColor;
            }
        }
        else{// the 4x row
            if (count == 0){
                retColor = goodColor;
            }
            else{
                retColor = badColor;
            }
        }
        
        return retColor;
    }
    
    // Constants
    // Index 17 = ???/invalid
    public final String basicTypes[] = {"NOR", "FIR", "WAT", "ELE", "GRS", "ICE", "FTG", "PSN", 
        "GRD", "FLY", "PSY", "BUG", "RCK", "GST", "DRG", "DRK", "STL", "???"};
    public final String expandedTypes[] = {"NORMAL", "FIRE", "WATER", "ELECTRIC", 
        "GRASS", "ICE", "FIGHTING", "POISON", "GROUND", "FLYING", "PSYCHIC", "BUG", "ROCK", 
        "GHOST", "DRAGON", "DARK", "STEEL", "???"};
    public final Color typeColors[] = {new Color(102,102,102), new Color(204,0,0), new Color(0,0,204),
        new Color(230,172,0), new Color(51,153,51), new Color(51,102,153), new Color(153,70,50),
        new Color(71,50,154), new Color(102,51,0), new Color(102,102,204), new Color(102,0,153),
        new Color(128,153,0), new Color(70,60,51), new Color(67,25,93), new Color(0,0,102),
        Color.black, new Color(77,77,77)};
    
    public final Color goodColor = new Color(0,164,0);
    public final Color okayColor = new Color(50,0,234);
    public final Color badColor = new Color(204,0,0);
    public final Color zeroColor = new Color(153,102,0);
    
    public int dexTotal;
    
    // Stuff that needs to be setup, then left like that
    public String[] pkmnNames;   // Everyone's name, by nat.dex. #
    public String pkmnAlts[];    // Alternate formes, since... I forgot to add them originally
    public List pkmnSorted;      // The sorted of above
    public int pkmnTypes[][];    // Everyone's types, by nat.dex. # (type 3 and 4 are 
                                 // optional abilities affecting resistances, eg Levitate)
    
    // Fully dynamic stuff
}
