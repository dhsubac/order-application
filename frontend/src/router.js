
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import CounterInventoryManager from "./components/listers/CounterInventoryCards"
import CounterInventoryDetail from "./components/listers/CounterInventoryDetail"

import CouponCouponManager from "./components/listers/CouponCouponCards"
import CouponCouponDetail from "./components/listers/CouponCouponDetail"

import DeliveryDeliveryManager from "./components/listers/DeliveryDeliveryCards"
import DeliveryDeliveryDetail from "./components/listers/DeliveryDeliveryDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/counters/inventories',
                name: 'CounterInventoryManager',
                component: CounterInventoryManager
            },
            {
                path: '/counters/inventories/:id',
                name: 'CounterInventoryDetail',
                component: CounterInventoryDetail
            },

            {
                path: '/coupons/coupons',
                name: 'CouponCouponManager',
                component: CouponCouponManager
            },
            {
                path: '/coupons/coupons/:id',
                name: 'CouponCouponDetail',
                component: CouponCouponDetail
            },

            {
                path: '/deliveries/deliveries',
                name: 'DeliveryDeliveryManager',
                component: DeliveryDeliveryManager
            },
            {
                path: '/deliveries/deliveries/:id',
                name: 'DeliveryDeliveryDetail',
                component: DeliveryDeliveryDetail
            },




    ]
})
