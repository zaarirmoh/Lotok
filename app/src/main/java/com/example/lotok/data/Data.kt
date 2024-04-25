package com.example.lotok.data

import com.example.lotok.R


private const val id: Int = 0
object Data{
    val carPostsList: List<CarPost> = listOf(
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 3.5,
            description = " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore . Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore . Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ."
            ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 2.5,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 4.0,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 5.0,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 3.5,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 3.5,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 3.5,
        ),
        CarPost(
            id = id,
            imgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            name = "M4 Competition",
            mark = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000,
            weekPrice = 12000,
            rating = 3.5,
        ),
    )
    val carBrandsList: List<CarBrand> = listOf(
        CarBrand(
            id = 1,
            brandPic = R.drawable.tesla,
        ),
        CarBrand(
            id = 2,
            brandPic = R.drawable.bmw),
        CarBrand(
            id = 3,
            brandPic = R.drawable.auddi,
        ),
        CarBrand(
            4,
            R.drawable.mercedes,
        ),
        CarBrand(
            5,
            R.drawable.tesla,
        ),
        CarBrand(
            6,
            R.drawable.bmw,
        ),
        CarBrand(
            7,
            R.drawable.auddi,
        ),
        CarBrand(
            8,
            R.drawable.mercedes,
        ),
        CarBrand(
            9,
            R.drawable.tesla,
        ),
        CarBrand(
            10,
            R.drawable.bmw,
        ),
        CarBrand(
            11,
            R.drawable.auddi,
        ),
        CarBrand(
            12,
            R.drawable.mercedes,
        ),
    )
    val categoriesList: List<Category> = listOf(
        Category(imgSrc = R.drawable.car_category),
        Category(imgSrc = R.drawable.motorcycle_category),
        Category(imgSrc = R.drawable.master_category),
        Category(imgSrc = R.drawable.truck_category),
    )
}