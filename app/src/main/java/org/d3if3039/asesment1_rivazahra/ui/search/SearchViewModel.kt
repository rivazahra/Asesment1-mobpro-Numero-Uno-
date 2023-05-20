package org.d3if3039.asesment1_rivazahra.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3039.asesment1_rivazahra.model.Food

class SearchViewModel: ViewModel() {
    val _listData = MutableLiveData<List<Food>>()
    fun listData(): LiveData<List<Food>> = _listData

    fun fulllistMakanan() = getdata()
    fun getdata(): List<Food> {
        return listOf(
            Food(
                "Pasta",
                "Pasta dari Italia adalah hidangan yang terbuat dari adonan tepung terigu, air, dan telur (atau tanpa telur dalam beberapa jenis pasta) yang dicetak menjadi berbagai bentuk seperti spaghetti, penne, farfalle, dan lain-lain. Pasta biasanya dimasak dalam air yang direbus dan dihidangkan dengan berbagai macam saus seperti saus tomat, saus pesto, saus krim, atau saus daging.\n" +
                        "\n" +
                        "Pasta adalah hidangan yang sangat populer di Italia dan telah menjadi makanan pokok di negara ini selama berabad-abad. Ada ratusan jenis pasta yang berbeda dan setiap jenis pasta memiliki karakteristik uniknya sendiri. Beberapa jenis pasta khusus hanya dapat ditemukan di wilayah tertentu di Italia.\n" +
                        "\n" +
                        "Pasta juga sering disajikan dengan berbagai bahan tambahan seperti sayuran, keju, daging, atau ikan untuk membuat hidangan yang lebih lengkap. Pasta juga sering dijadikan hidangan pembuka atau makanan penutup di restoran Italia. Hidangan pasta Italia selalu dianggap sebagai hidangan yang lezat, sederhana, dan memuaskan.",

                ),
            Food(
                "Risotto",
                "Risotto adalah hidangan Italia yang terbuat dari nasi yang dimasak dengan kaldu atau air, bawang, anggur, dan bahan lain seperti sayuran, daging, atau ikan. Risotto biasanya dimasak dengan cara aduk terus-menerus untuk membentuk lapisan krim yang lembut dan konsisten di dalamnya.\n" +
                        "\n" +
                        "Nasi yang digunakan dalam risotto adalah jenis beras khusus dari Italia, seperti Arborio, Carnaroli, atau Vialone Nano, yang memiliki kandungan pati yang tinggi. Pati dalam beras inilah yang memberikan tekstur krem dan kenyal yang unik pada risotto.\n" +
                        "\n" +
                        "Risotto memiliki banyak variasi yang berbeda, tergantung pada bahan tambahan dan saus yang digunakan. Beberapa jenis risotto populer di Italia termasuk risotto alla milanese (dengan keju parmesan dan kunyit), risotto al funghi (dengan jamur), dan risotto ai frutti di mare (dengan campuran seafood).\n" +
                        "\n" +
                        "Risotto biasanya dihidangkan sebagai hidangan utama dan sering disajikan sebagai makanan hangat dalam mangkuk kecil atau piring datar. Hidangan ini sering dianggap sebagai hidangan yang elegan dan rumit karena membutuhkan waktu dan perhatian ekstra dalam persiapannya.",

                ),
            Food(
                "Pizza",
                "Pizza adalah hidangan khas Italia yang terdiri dari adonan roti pipih yang dilapisi dengan saus tomat, keju, dan berbagai macam topping sesuai selera. Adonan pizza terbuat dari campuran tepung terigu, ragi, garam, air, dan minyak zaitun, yang diuleni dan dibiarkan mengembang sebelum dipanggang dalam oven.\n" +
                        "\n" +
                        "Saus tomat yang digunakan dalam pizza biasanya terbuat dari tomat segar yang dicincang, bawang putih, dan rempah-rempah seperti oregano dan basil. Keju yang paling sering digunakan dalam pizza adalah mozzarella, tetapi ada juga yang menggunakan keju Parmesan atau keju cheddar.\n" +
                        "\n" +
                        "Topping yang digunakan dalam pizza sangat bervariasi, tergantung pada selera pribadi dan tradisi regional. Beberapa topping populer di Italia termasuk pepperoni, jamur, sosis, paprika, bawang, dan zaitun. Ada juga pizza vegetarian yang hanya menggunakan sayuran sebagai toppingnya.\n" +
                        "\n" +
                        "Pizza biasanya dihidangkan dalam bentuk bulat dengan potongan-potongan segitiga. Hidangan ini dapat disajikan sebagai hidangan utama atau sebagai camilan. Pizza juga sering dijual dalam bentuk frozen pizza yang mudah untuk dipanaskan kembali di rumah.\n" +
                        "\n" +
                        "Pizza adalah hidangan yang populer di seluruh dunia dan telah diadaptasi dengan berbagai topping dan variasi sesuai dengan selera lokal. Namun, pizza asli Italia tetap dianggap sebagai hidangan yang lezat dan otentik dengan rasa yang unik dan tekstur yang khas.",

                ),
            Food(
                "Tortellini",
                "Tortellini adalah makanan pasta tradisional dari Italia yang biasanya terbuat dari adonan pasta segar yang dipotong menjadi bentuk kecil seperti permen, kemudian diisi dengan berbagai jenis isian, seperti daging sapi, daging babi, keju, atau sayuran. Bentuk tortellini yang khas adalah cincin yang dilipat dua dengan ujung-ujungnya disatukan sehingga menyerupai bentuk topi atau perahu.\n" +
                        "\n" +
                        "Tortellini berasal dari kota Bologna di Italia dan diyakini pertama kali dibuat pada abad ke-16. Makanan ini biasanya disajikan dalam kaldu atau dimasak dengan saus tomat atau saus putih. Tortellini juga dapat disajikan sebagai hidangan utama atau sebagai hidangan pembuka.\n" +
                        "\n" +
                        "Tortellini telah menjadi salah satu makanan pasta yang terkenal di seluruh dunia dan sering dianggap sebagai simbol kuliner Italia. Variasi modern dari tortellini juga dapat ditemukan dengan berbagai jenis isian dan saus yang berbeda-beda.\n",

                ), Food(
                "Lasagna",
                "Lasagna adalah hidangan khas Italia yang terdiri dari lapisan-lapisan pasta kering yang dipanggang, saus daging, keju ricotta atau keju parmesan, saus tomat, dan sayuran seperti bayam atau zucchini. Setiap lapisan diatasnya diberi saus dan keju kemudian dipanggang dalam oven.\n" +
                        "\n" +
                        "Pasta lasagna terbuat dari adonan tepung terigu dan telur yang digulung menjadi lembaran tipis, kemudian direbus dan digunakan untuk membentuk lapisan-lapisan dalam hidangan lasagna.\n" +
                        "\n" +
                        "Saus daging dalam lasagna dibuat dengan memasak daging sapi atau babi dengan saus tomat, bawang, bawang putih, dan rempah-rempah seperti basil dan oregano. Keju ricotta atau keju parmesan ditambahkan ke antara lapisan-lapisan pasta, sementara sayuran seperti bayam atau zucchini dapat ditambahkan ke dalam saus daging.\n" +
                        "\n" +
                        "Setelah lapisan pasta, saus dan keju dilapisi dengan sempurna, lasagna dipanggang dalam oven hingga lapisan atasnya kecokelatan dan krispi. Lasagna biasanya dihidangkan sebagai hidangan utama dan dapat disajikan dengan salad segar dan roti italia sebagai sajian pelengkapnya.\n" +
                        "\n" +
                        "Lasagna adalah hidangan yang populer di seluruh dunia dan sering menjadi makanan yang disukai oleh anak-anak maupun orang dewasa. Hidangan ini sering dianggap sebagai hidangan yang mengenyangkan, lezat dan meriah, dengan banyak lapisan berbeda yang memberikan sensasi rasa dan tekstur yang beragam.",

                ), Food(
                "Tiramisu",
                "Tiramisu adalah hidangan penutup khas Italia yang terbuat dari biskuit ladyfingers yang dicelupkan ke dalam campuran kopi hitam dan likuer, kemudian dilapisi dengan krim keju mascarpone yang lembut dan manis.\n" +
                        "\n" +
                        "Biskuit ladyfingers yang digunakan dalam tiramisu terbuat dari adonan telur, tepung terigu, dan gula yang dipanggang hingga kering dan renyah. Campuran kopi dan likuer seperti Marsala atau Amaretto kemudian dicampurkan bersama untuk memberikan rasa yang kuat dan kaya pada hidangan ini.\n" +
                        "\n" +
                        "Krim keju mascarpone yang digunakan dalam tiramisu dibuat dengan mencampurkan keju mascarpone yang lembut dengan telur, gula, dan kadang-kadang juga dengan sedikit krim. Krim ini kemudian dicampurkan dan diselimuti dengan biskuit ladyfingers yang telah direndam dalam campuran kopi dan likuer.\n" +
                        "\n" +
                        "Tiramisu biasanya disajikan dalam bentuk kue atau dessert dalam gelas yang dihiasi dengan taburan cokelat bubuk atau serutan cokelat. Hidangan ini biasanya dihidangkan sebagai hidangan penutup setelah hidangan utama dan sering disajikan pada acara-acara khusus seperti Natal dan ulang tahun.\n" +
                        "\n" +
                        "Tiramisu adalah hidangan penutup yang sangat populer di seluruh dunia karena rasa yang lezat dan teksturnya yang kaya. Hidangan ini sering dianggap sebagai hidangan yang elegan dan klasik, dengan sentuhan rasa kopi dan keju yang khas dari Italia.",

                )
        )
    }
}