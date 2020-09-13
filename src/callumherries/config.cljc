(ns callumherries.config
  (:require [callumherries.routes :as routes]
            [callumherries.pages.posts :as posts]
            [callumherries.components :refer [page]]
            [callumherries.pages.index :as index]
            [callumherries.pages.about :as about]))

(def posts-pages
  (into {}
        (for [{:keys [page-key hiccup]} posts/posts]
          [page-key {:hiccups (page hiccup)}])))

(def pages
  (merge posts-pages
         {:page/index {:hiccups (page (index/hiccup))}
          :page/about {:hiccups (page (about/hiccup))}}))

(defn config []
  {:resource-dir     "resources"
   :target-dir       "build"
   :pages            pages
   :routes           routes/routes
   :default-route    :page/index
   :default-template [:html
                      [:head
                       [:title "callumherries"]
                       [:meta {:charset "utf-8"}]
                       [:link {:href "/public/css/callumherries.css" :rel "stylesheet" :type "text/css"}]]
                      [:body :volcano/hiccups]]
   :exclude-files    #{"index.html"}
   :exclude-dirs     #{"js"}})
