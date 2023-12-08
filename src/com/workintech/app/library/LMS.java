package com.workintech.app.library;

import com.workintech.app.library.enums.Members;
import com.workintech.app.library.model.books.*;
import com.workintech.app.library.model.library.*;
import com.workintech.app.library.model.person.*;

public class LMS {
    public static void main(String[] args) {

        /* BOOK INSTANCES */
        Book nutuk = new StudyBook(
                "Mustafa Kemal Atatürk",
                "Nutuk",
                1923,
                "1927",
                900,
                "Nutuk, milli mücadele dönemini ve sonrasında yaşanan süreçleri ele alan bir eserdir. Milli mücadele ardından Türkiye Büyük Millet Meclisi'nin kuruluş dönemi ve Türkiye'nin kuruluş sürecini ele alan bir kitaptır."
        );
        Book geometri = new StudyBook(
                "Mustafa Kemal Atatürk",
                "Geometri",
                48,
                "1937",
                76,
                "Geometri - Mustafa Kemal Atatürk Bu kitabı Atatürk, ölümünden bir buçuk yıl kadar önce, III. Türk Dil Kurultayı''ndan hemen sonra, 1936-1937 yılı kış aylarında Dolmabahçe Sarayı''nda kendi eliyle yazmıştır."
        );
        Book sekerPortakali = new Novel(
                "Jose Mauro De Vasconcelos",
                "Şeker Portakalı",
                60,
                "1968",
                184,
                "Çevresindeki yoksulluğa hayalleriyle meydan okuyan afacan Zezé, ailesi maddi imkânsızlıklar nedeniyle yeni bir eve taşındığı zaman orada karşılaştığı ilk canlıyı bir şeker portakalı fidanını arkadaş edinmeyi başarır. Bu fidan onun sırdaşı ve yoldaşı olacaktır."
        );
        Book caliKusu = new Novel(
                "Reşat Nuri Güntekin",
                "Çalıkuşu",
                30,
                "1922",
                409,
                "Romanda, İstanbul köklü bir ailenin kızı olan çocuk ruhlu Feride'nin çok sevdiği nişanlısı tarafından ihanete uğramasıyla kendini öğretmenlik mesleğine adaması ve hayatını kazanabilmek için Anadolu'da şehir şehir dolaşması anlatılır."
        );
        Book popSciTR = new Magazine(
                "Dogan Burda Dergi",
                "Popular Science",
                12,
                "2023",
                108,
                "1872 yılında Amerika'da yayımlanmaya başlayan popüler bilim dergisidir. Genel okuyucuya hitap eden dergi, bilim ve teknoloji konularını irdeler. Popular Science, 30'dan fazla dile çevrilmekte ve 45 ülkede yayınlanmaktadır."
        );
        Book thomasCalculus = new StudyBook(
                "Frank R. Giordano",
                "Thomas Calculus",
                1156,
                "1951",
                1216,
                "Thomas' Calculus helps students reach the level of mathematical proficiency and maturity you require, but with support for students who need it through its balance of clear and intuitive explanations, current applications, and generalized concepts."
        );
        Book tehlikeOyunlar = new Novel(
                "Oğuz Atay",
                "Tehlikeli Oyunlar",
                149,
                "2000",
                479,
                "Türkiye’de postmodern edebiyatın en güçlü temsilcisi olarak görülen Oğuz Atay, Tehlikeli Oyunlar romanıyla günümüzde de sıkça konuşulmaya devam ediyor. Yazarın Tutunamayanlar’dan sonra ikinci eseri olarak kaleme aldığı Tehlikeli Oyunlar, bireyin toplum ve kendisi ile olan sorunlarını ele alıyor. Başkahramanın kişiliği bakımından Tutunamayanlar ile aynı düzlemde ilerleyen roman, bu yönüyle Atay’ın “anlaşılamama” kaygısını yeniden ve güçlü bir şekilde vurguluyor."
        );
        Book tutunamayanlar = new Novel(
                "Oğuz Atay",
                "Tutunamayanlar",
                149,
                "1972",
                479,
                "Tutunamayanlar, Türk edebiyatının en önemli eserlerinden biridir. Berna Moran, Oğuz Atay'ın bu ilk romanını \"hem söyledikleri hem de söyleyiş biçimiyle bir başkaldırı\" olarak niteler. Moran'a göre \"Oğuz Atay'ın mizah gücü ve duyarlığı ve kullandığı teknik incelikler, Tutunamayanlar'ı büyük bir yeteneğin ürünü yapmış, eserdeki bu yetkinlik Türk romanını çağdaş roman anlayışıyla aynı hizaya getirmiş ve ona çok şey kazandırmıştır."
        );
        Book imhotep = new Magazine(
                "Adli Tıp Uzmanları Derneği",
                "Imhotep",
                45,
                "2021",
                120,
                "Kral Zoser’in veziri, hekimi ve daha sonra Mısırlı Tıp Tanrısı olan ve uzmanlık derneğimizin haber bülteni yayın organı İmhotep 1994’de yayımlanmaya başlamış ve en son 2005 yılında çıkmıştı. Aradan bu kadar uzun zaman geçmesine rağmen İmhotep hiç unutulmadı."
        );
        Book nineteenEightyFour = new Novel(
                "George Orwell",
                "1984",
                54,
                "1948",
                352,
                "Distopya olarak nitelendirilen George Orwell’ın bu şahane eseri, geçmişin aslında ne kadar da gelecekten izler taşıdığını ortaya koyuyor. 1948’de kaleme aldığı bu eser ile Orwell, günümüz modern dünyasına bir protesto bırakıyor."
        );
        Book hayvanCiftligi = new Novel(
                "George Orwell",
                "Hayvan Çiftliği",
                36,
                "1945",
                152,
                "Fazla çalıştırılan ve kötü muamele gören hayvanlar bir gün toplanıp yaşadıkları çiftliği ele geçirirler. Sonunda söz sahibi olmuşlardır, çiftlikte daha adil ve eşit bir toplum oluşturmaya kararlıdırlar. Domuzların öncülüğünde bu yeni düzeni kurmak için çalışmaya başlarlar. "
        );


        /* LIBRARY INSTANCE*/
        Library library = new Library();

        /* ADDED NEW BOOK  */
        library.newBook(nutuk);
        library.newBook(sekerPortakali);
        library.newBook(popSciTR);
        library.newBook(thomasCalculus);
        library.newBook(caliKusu);
        library.newBook(tehlikeOyunlar);
        library.newBook(imhotep);
        library.newBook(geometri);
        library.newBook(hayvanCiftligi);
        library.newBook(nineteenEightyFour);
        library.showBooks();

        /* LIBRARIAN INSTANCE */
        Librarian librarian = new Librarian("Server Server", "1231231", library);



        /* AUTHOR INSTANCE */
        Person ataturk = new Author("Mustafa Kemal Atatürk");
        Person oguzAtay = new Author("Oğuz Atay");
        Person georgeOrwell = new Author("George Orwell");
        Person atud = new Author("Adli Tıp Uzmanları Derneği");
        Person resatNuriGuntekin = new Author("Reşat Nuri Güntekin");
        Person frGiardino = new Author("Frank R. Giordano");
        Person vasconcelos = new Author("Jose Mauro De Vasconcelos");
        Person doganBurdaDergi = new Author("Dogan Burda Dergi");

        /* AUTHOR'S BOOKS ADDED */
        ataturk.addBook(nutuk);
        ataturk.addBook(geometri);
        oguzAtay.addBook(tutunamayanlar);
        oguzAtay.addBook(tehlikeOyunlar);
        georgeOrwell.addBook(nineteenEightyFour);
        georgeOrwell.addBook(hayvanCiftligi);
        atud.addBook(imhotep);
        resatNuriGuntekin.addBook(caliKusu);
        frGiardino.addBook(thomasCalculus);
        vasconcelos.addBook(sekerPortakali);
        doganBurdaDergi.addBook(popSciTR);

        /* READER INSTANCES */
        Reader mali = new Student("Mehmet Ali Değirmenci", "10.10.2020", "Adana", "05465214321");
        Reader ramazan = new Faculty("Ramazan Öztürk", "12.10.2019", "Aydın", "05425214321");
        Reader hasan = new Faculty("Hasan Eker", "03.05.2016", "Aydın", "05325214321");
        Reader fatih = new Student("Fatih Kot","10.07.2023","Trabzon","05052134651");
        Reader mali2 = new Student("Mehmet Ali Değirmenci", "10.05.2021", "Adana", "05465214321");

        /* READERS REGISTERED TO LIBRARY */
        library.registerReader(hasan);
        library.registerReader(ramazan);
        library.registerReader(mali);
        library.registerReader(fatih);
        library.registerReader(mali2);

        librarian.issueBook(mali,nutuk,"01.11.2023");
        librarian.issueBook(fatih,popSciTR,"05.12.2023");
        librarian.issueBook(fatih,imhotep,"02.12.2023");
        librarian.issueBook(ramazan,nineteenEightyFour,"05.11.2023");
        librarian.issueBook(hasan,hayvanCiftligi,"12.09.2023");


        librarian.createBill(mali);
        librarian.createBill(ramazan);
        librarian.createBill(fatih);

        librarian.showBill(fatih);


        library.showBook(imhotep);
        mali.showPerson();
        System.out.println("********************************");
        library.showBooks();
        library.showBills();
        library.showBooks("Novel");
        library.showReaders();

    }
}
