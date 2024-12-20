
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import CounterInventoryManager from "./components/listers/CounterInventoryCards"
import CounterInventoryDetail from "./components/listers/CounterInventoryDetail"




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





    ]
})
