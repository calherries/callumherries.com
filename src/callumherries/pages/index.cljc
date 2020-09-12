(ns callumherries.pages.index
  (:require [callumherries.routes :as routes]
            [callumherries.pages.posts :as posts]
            [bidi.bidi :as b]))

(defn hiccup []
  (list
    [:h1 "Callum Herries Hey"]
    [:p "This is an index page and its content is up to you! Also visit "
     [:a {:href (b/path-for routes/routes :page/about)} "about page"] "."]
    [:p {:style {:color            "navy"
                 :background-color "lightblue"
                 :padding          5}}
     "You can use any hiccup you want:"]
    [:ul (for [{:keys [page-key title date]} posts/posts]
           [:li
            [:div date "  " [:a {:href (str "/posts/" (name page-key) ".html")} title]]])]))
