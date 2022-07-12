package br.com.app5m.skipitrestaurantes.controller.webservice


import br.com.app5m.skipitrestaurantes.model.Address
import br.com.app5m.skipitrestaurantes.model.AuxAddresses
import br.com.app5m.skipitrestaurantes.model.Category.Category
import br.com.app5m.skipitrestaurantes.model.Fcm
import br.com.app5m.skipitrestaurantes.model.Reserv.Reserv
import br.com.app5m.skipitrestaurantes.model.Reserv2.Reserv2
import br.com.app5m.skipitrestaurantes.model.fila.Queue
import br.com.app5m.skipitrestaurantes.model.restaurant.Restaurant
import br.com.app5m.skipitrestaurantes.model.user.User


interface WSResult {

    fun responseUser(user: User, type: String){}
    fun responseRestaurant(restaurent: Restaurant, type: String){}
    fun resultFcm(fcm: Fcm?, type: String?){}
    fun resultReserv(reserv: Reserv?, type: String?){}
    fun resultReserv(reser2: Reserv2?, type: String?){}
    fun responseAddress(addressList: List<Address>, type: String){}
    fun responseAddress(addressList: AuxAddresses, type: String){}
    fun responseCategory(category: Category, type: String){}
    fun responseQueue(queue: Queue, type: String){}





    fun error( error: String){}
}
