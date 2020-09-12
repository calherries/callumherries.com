(ns callumherries.config
  (:require [callumherries.routes :as routes]
            [callumherries.pages.posts :as posts]
            [callumherries.pages.index :as index]
            [callumherries.pages.contact :as contact]))

(def posts-pages
  (into {}
        (for [{:keys [page-key hiccup]} posts/posts]
          [page-key {:hiccups hiccup}])))

(def pages
  (merge posts-pages
         {:page/index   {:hiccups (index/hiccup)}
          :page/contact {:hiccups (contact/hiccup)}}))

(defn config []
  {:resource-dir     "resources"
   :target-dir       "build"
   :pages            pages
   :routes           routes/routes
   :default-route    :page/index
   :default-template [:html
                      [:head
                       [:title "callumherries"]
                       [:meta {:charset "utf-8"}]]
                      [:body :volcano/hiccups]]
   :exclude-files    #{"index.html"}
   :exclude-dirs     #{"js"}})
