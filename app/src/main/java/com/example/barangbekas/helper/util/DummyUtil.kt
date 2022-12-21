package com.example.barangbekas.helper.util

import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.data.remote.model.Product

object DummyUtil {

    fun getCategories(): List<Category> =
        listOf(Category("Laptop"), Category("Hand Phone"), Category("Headset"), Category("Power Bank"), Category("Charger"))

    fun getDescription(): String = "SERI TERBARU!!!\n" +
            "\n" +
            "ASUS ZENBOOK DUO 14 UX482EGR IPS751 TOUCH I7 1195G7 16GB 512SSD MX450 2GB W11+OHS 14.0FHD IPS SPAD PEN BLU\n" +
            "\n" +
            "Spesifikasi : Display : 14.0-inch FHD (1920 x 1080) 16:9 Anti-glare display sRGB: 100% touch 400nits Processor : Intel&reg; Core&trade; i7-1195G7 Processor 2.8 GHz (12M Cache, up to 4.7 GHz, 4 cores) Memory : 16GB LPDDR4X Hard Drive : SSD 512GB PCIE Graphics : Intel&reg; Iris Xe Graphics +NVIDIA&reg; GeForce&reg; MX450 2GB GDDR6 Optical Drive : - Operating System : Windows 11 +OHS 2021 Camera : INTEGRATED Networking : 802.11ax+Bluetooth 5.0 (Dual band) 2*2 Slots/Interface :\n" +
            "\n" +
            "1x USB 3.2 Gen 1 Type-A 2x Thunderbolt&trade; 4 supports display / power delivery Micro SD card reader 1x HDMI 1.4 1x 3.5mm Combo Audio Jack Battery : 70WHrs, 4S1P, 4-cell Li-ion 65W power adapter Plug Type: &oslash;4.5 (mm) (Output: 19V DC, 3.42A, 65W) (Input: 100-240V AC, 50/60Hz universal)\n" +
            "\n" +
            "System Dimensions : 1.99cm (W) x 32.3(D) x 22.3 (H) Mm Weight : 1.5 kg Warranty : 2 Year Asus Warranty Bonus : Sleeve, Stylus, Stand\n" +
            "\n" +
            "Garansi Resmi Asus Indonesia 2 Tahun Garansi Toko 3 Hari"

    fun getProduct(): Product = Product(
        id = "3245",
        name = "Laptop Asus Zenfone 16GB 1TB",
        categoryId = "Laptop",
        description = getDescription(),
        price = "14000000",
        imageUrl = "https://sample-url.com"
    )

    fun getProducts(): List<Product> = listOf(
        Product(
            id = "3245",
            name = "Laptop Asus Zenfone",
            categoryId = "Laptop",
            description = getDescription(),
            price = "14000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3246",
            name = "Laptop Vivo",
            categoryId = "Laptop",
            description = getDescription(),
            price = "10000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3247",
            name = "Laptop Sony 16 GB",
            categoryId = "Laptop",
            description = getDescription(),
            price = "15000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3248",
            name = "Laptop MSI i7",
            categoryId = "Laptop",
            description = getDescription(),
            price = "20000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3249",
            name = "Laptop ROG 2 cooler",
            categoryId = "Laptop",
            description = getDescription(),
            price = "19000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3250",
            name = "Laptop Lenovo 1 TB",
            categoryId = "Laptop",
            description = getDescription(),
            price = "12000000",
            imageUrl = "https://sample-url.com"
        ),
        Product(
            id = "3251",
            name = "Laptop Acer Swift",
            categoryId = "Laptop",
            description = getDescription(),
            price = "11000000",
            imageUrl = "https://sample-url.com"
        )
    )
}