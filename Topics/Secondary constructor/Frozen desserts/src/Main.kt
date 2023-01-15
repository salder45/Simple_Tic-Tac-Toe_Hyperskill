const val PRICE_POPSICLES = 7
const val PRICE_SCOOPS = 5
const val PRICE_TOPPINGS = 2
class IceCreamOrder {
    var price: Int = 0
    constructor(popsicles: Int) {
        this.price = popsicles * PRICE_POPSICLES
    }

    constructor(scoops: Int, toppings: Int) {
        this.price = scoops * PRICE_SCOOPS + toppings * PRICE_TOPPINGS
    }
}