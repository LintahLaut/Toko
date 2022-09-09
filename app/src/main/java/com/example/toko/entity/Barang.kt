package com.example.toko.entity

class Barang(var namaSepatu: String, var stok: Int) {
    companion object{
        @JvmField
        var listOfBarang = arrayOf(
            Barang("Converse x Virgil Abloh", 10),
            Barang("Vans Slip On Classic", 15),
            Barang("Superga Cotu Sneakers", 20),
            Barang("League New Kreate Chukka", 10),
            Barang("Casual Piero Shadow P20608", 10),
            Barang("REEBOK Original Instalite", 10),
            Barang("BRODO Signore Boots", 10),
            Barang("Sneaker Suede Ignite", 10),
            Barang("Anvil Royal Brown", 10),
            Barang("Aztrek Chalk Royal Rose", 10),
        )
    }
}