package spock.example

import spock.lang.Specification

class ProductSpec extends Specification {
    void "First test"(){
        List<Product>products = []
        products << new Product(name: "p1", price: 100)
        products << new Product(name: "p2", price: 5000)
        products << new Product(name: "p2", price: 6000)
        
        def x = Product.getProductsGroupedByPrice(products)
        println ">>>>>> "+x

        expect:
        true
    }
}
