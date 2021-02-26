import { compose, createStore, applyMiddleware } from 'redux'
import { createLogger } from 'redux-logger'
import axiosMiddleWare from '../middlewares/axiosMiddleware'
import reducers from '../reducers'

export default function Store(preloadedState) {
	//let middlewares = process.env.NODE_ENV === 'development' ? devMiddlewares : prodMiddlewares
    //const store = createStore(storefrontApp, preloadedState, compose(...middlewares))
    let middlewares = [applyMiddleware(axiosMiddleWare(), createLogger())]
    const store = createStore(reducers, preloadedState, compose(...middlewares))
    return store
}