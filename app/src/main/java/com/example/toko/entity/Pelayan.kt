package com.example.toko.entity

class Pelayan(var nama: String, var umur: Int) {
    companion object{
        @JvmField
        var listOfPelayan = arrayOf(
            Pelayan("Putri Selistia", 20),
            Pelayan("Budi Agung", 23),
            Pelayan("Rizky Febyun", 22),
            Pelayan("Zara Araka", 20),
            Pelayan("M. Sudirman Pamuja", 21),
            Pelayan("Luluk Mawar", 25),
            Pelayan("Hariadi", 21),
            Pelayan("Fedrik Karmawan", 21),
            Pelayan("Gunawan Adi", 20),
            Pelayan("Sarah Melody", 19),
        )
    }
}