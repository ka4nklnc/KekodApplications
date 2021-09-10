package com.puasnow.news.mdoels

import androidx.annotation.DrawableRes
import com.puasnow.news.R

data class NewsModel
    (
    @DrawableRes val img: Int,
    @DrawableRes val sourceimg: Int,
    val sourcename: String,
    val title: String,
    val timeago: String,
    val text: String
    )

        fun getFakeData():ArrayList<NewsModel> {
            val array = ArrayList<NewsModel>()
            for (item in 0..4){
                array.add(
                    NewsModel(
                    R.drawable.img_news_salca,
                        R.drawable.img_source_sondakika,
                        sourcename="SonDakika.com",
                        title="Konserve salçalardaki ölümcül zehirlenme tehlikesi! Belirtileri 72 saat sonra çıkıyor",
                        timeago="2 saat önce",
                        text="Doç. Dr. Uzel, konserve gıdalar hazırlanırken tüketicilerin uyması gereken hijyen koşullarını şöyle anlattı:\"Tüketiciler özellikle sebze türü gıdaların kurutulması ya da dondurularak tüketilmesi gibi alternatif metotları da denemeli. Evde hazırlanması tercih edilen konserveler için cam kavanozlar kullanılmalı, plastik ambalajlar kullanılıyorsa mutlaka onaylı malzeme olmasına dikkat edilmeli. Ayrıca, şekli bozulmuş ve paslı olan kapaklar kesinlikli kullanılmamalı. Kapaklar en az 15-20 dakika kaynatılmalı ve her kullanımda yenilenmeli. Gıdalar, asitlik derecesine uygun olan sıcaklık ve süre kombinasyonunda pişirilmeli. Kavanozda kapakta şişkinlik ve sızıntı olmamalı. Dışa doğru bombe şeklinde şişme yapan, tat, renk ve koku bakımından kötü olan konservelerin tüketilmemesi gerekir. Tatta bozulma her zaman net olarak anlaşılamayacağı için gerekli tedbirler alınmalıdır. Eğer konservelenmiş gıda marketten satın alınıyorsa son kullanma tarihi, etiket ve resmi kurum izin beyanları dikkatlice kontrol edilmeli. Hasar görmüş, dışa doğru bombe yapmış, paslanmış, sızıntısı olan ambalajlar ve kapağı açılınca fışkırma yapan konserveler kesinlikle tercih edilmemeli\".BELİRTİLERİ 72 SAAT SONRA ÇIKIYORBotulismus vakası hakkında da bilgi veren Ruhan Aşkın Uzel, \"Botulismus zehirlenmesine 'clostridium botulinum' adı verilen bir bakterinin toksini neden oluyor. Clostridium botulinum, basınç ve sıcaklığa dayanımı yüksek olan dirençli bir mikroorganizma. Bu tip zehirlenmeye neden olan etmenlerin başında, konservelerin büyük bir kısmının yetersiz sürede, gerekenden daha düşük sıcaklıkta, dolayısıyla da yeterince pişirilmeden hazırlanması geliyor. Rahatsızlık, konservenin tüketilmesini takiben kişinin direnci, ortam koşulları gibi etmenlere bağlı olarak 12 ila 72 saat sonra şiddetli karın ağrısı, bulantı, kusma, görmede bozukluk, kaslarda güçsüzlük gibi şikayetler ile kendini gösteriyor. Bu durumda zamanında müdahale ve doğru tedavi edilmesi gereken bir durum oluşur ki rahatsızlık görülür görülmez bireysel önlemlere başvurmadan, en kısa zamanda en yakın hastaneye başvurmak gerekli\" dedi."
                    )
                )
                array.add(
                    NewsModel(
                        R.drawable.img_news_kedi,
                        R.drawable.img_source_sabah,
                        sourcename="Sabah",
                        title="Evde kedi besleyen her dört kişiden birinde kedi alerjisi var",
                        timeago="4 saat önce",
                        text="Kedi alerjenlerine bağlı oluşan bu hassasiyet nasıl meydana gelir, başlıca sebebi nedir?\n" +
                                "Alerjen hassasiyetine kedilerin tükürüğünde doğal olarak ürettiği Fel d 1 adı verilen protein sebep oluyor. Kedi alerjenleri ve bu alerjenlerin yüzde 60–90'ını oluşturan Fel d 1; kedilerin tükürük ve yağ bezlerinden salgılanıyor ve kedinin temizlenmesi sırasında ortama saçılıyor.\n" +
                                "■ Tüm kediler alerjen üretiyor mu? Alerjik reaksiyonların önlenmesi adına neler yapılabilir?\n" +
                                "Tüm kediler; cins, yaş, tüy uzunluğu, cinsiyet veya vücut ağırlığı fark etmeksizin Fel d 1 üretiyor. Alınan önlemler arasında; kediye dokunur dokunmaz elini yıkamak veya evi ve mobilyaları her gün temizlemek gibi yöntemler yer alıyor. Araştırmalara göre, alerjik reaksiyon gösteren kedi sahiplerinin yüzde 53'ü kedisinin eşyalarını ayrı bir odada tutarken, yüzde 46'sı mobilyaların üzerini kapatmayı tercih ediyor. Belirtmek gerekir ki; saydığımız metotların hepsi alerjeni çevreye yayıldıktan sonra yönetmek için tasarlanan ve kedilerle sahipleri arasındaki etkileşimi sınırlayan yöntemler.\n" +
                                "\n" +
                                "BESİN KALİTESİ ETKİLER\n" +
                                "■ Kedi alerjisine yönelik yeni yaklaşımlar var mı?\n" +
                                "Bu sorunun üstesinden nasıl gelinebileceği konusunda uzun süredir yapılan çalışmalar var. Bilim insanları, besin takviyesi anlamında yeni yaklaşımlar geliştirmek için yıllardır araştırma yapıyor. Böylesi bir gelişme, hem evcil hayvanların hem de evcil hayvan sahiplerinin hayatında fark yaratma açısından faydalı olacaktır; çünkü besin kalitesi, hayvanların yaşam kalitesini artırma konusunda önemli bir faktör.")
                )
                array.add(
                    NewsModel(
                        R.drawable.img_news_epicapple,
                        R.drawable.img_source_technopat,
                        sourcename="Technopat",
                        title="Epic Games ve Apple Arasındaki Büyük Fortnite Davası Sonuçlandı",
                        timeago="7 saat önce",
                        text="Popüler battle royale oyunu Fortnite, Apple’ın uygulama mağazası App Store’a geldiğinden bu yana büyük tartışmalara ve anlaşmazlıklara yol açtı. Oyunun geliştiricisi ve yayıncısı olan Epic Games, Apple’ın uygulama içi satın alma sisteminde olan komisyon farkından dolayı kendi uygulama içi satın alma sistemini kullanıyordu. Ancak Apple, bunun App Store politikalarına aykırı olduğunu belirterek oyunu mağazadan kaldırdı.\n" +
                                "\n" +
                                "Epic Games, bunun haksız bir durum olduğunu savunarak Apple’a dava açma kararı almıştı. Uzun bir süredir herhangi bir gelişme olmayan dava nihayet bugün sonunda sonuçlandı.\n" +
                                "\n" +
                                "Epic Games\n" +
                                "\n" +
                                "Mahkeme sonucunda koyulan ihtiyati tedbir, Epic Games gibi kendi ödeme altyapılarını kullanan geliştiricilerin, Apple’ın App Store gelirlerini tehlikeye atması ihtimalini göz önünde bulunduruyor. Ancak geliştiriciler buna rağmen kendi ödeme altyapılarını kullanmakta özgür bırakıldı. Yani Apple, karara göre kendi ödeme altyapısını kullanan geliştiricilerin içeriklerini engelleyemeyecek.\n" +
                                "\n" +
                                "Bu karar dışında Apple’ın rekabete aykırı davranışlar sergilediği tespit edildi. Şirket, bu karara göre App Store politikalarını değiştirmek ve uygulama içi satın alma kurallarını gevşetmek zorunda kalacak.\n" +
                                "\n")
                )
                array.add(
                    NewsModel(
                        R.drawable.img_news_android12,
                        R.drawable.img_source_shiftdelete,
                        sourcename="Shift Delete",
                        title="Samsung, Android 12 tabanlı One UI 4.0 güncellemesini erteledi",
                        timeago="17 saat önce",
                        text="Eylül bitmeden yayınlanabilir\n" +
                                "Gecikmenin nedeni henüz bilinmiyor. Samsung'un beta güncellemelerinden sorumlu topluluk yöneticilerinden biri, One UI 4.0'ı bekleyen ve hayal kırıklığına uğrayan herkesten özür diledi.\n" +
                                "\n" +
                                "Şirket yeni bir tarih vermedi ancak büyük olasılıkla yeni ürün yazılımı Eylül ayı bitmeden yayınlanacak. One UI 4.0 beta sürümünün ilk olarak Samsung'un ana vatanı Güney Kore'deki kullanıcılara sunulması planlanıyor.\n" +
                                "\n")
                )
            }
            return  array;
        }
