(ns helloworld.views.home.page
  (:require [rum.core :as rum]
            [helloworld.views.layout :as layout]
            [helloworld.views.ui.about.about :refer [about]]
            [helloworld.views.ui.button.button :refer [button-square]]))


(rum/defc page [{:keys [lang loading title content]}]
  [:div#page.loading
   {:hx-get "/"
    :hx-swap "outerHTML swap:0.3s settle:0.3s"
    :hx-trigger "langSwitch"}

   [:div.absolute.top-0.w-full.py-3.hidden
    [:div.container.flex.items-center.justify-between
     [:span.text-sm.leading-8.text-lime-500 loading]]]

   [:header.absolute.top-0.w-full.py-3
    [:div.container.flex.items-center.justify-between
     [:h2.text-sm.text-lime-500 title]
     (button-square lang {:hx-get "/api/lang"
                          :hx-swap "none"})]]

   [:main.overflow-hidden
    [:div.container.flex.items-center.h-screen
     (about content)]]

   [:footer.absolute.bottom-0.w-full.py-3
    [:div.container.flex.items-center.justify-end
     [:time#js-time.text-sm.text-lime-500
      0]]]])


(defn render [{:keys [lang tr]}]
  (let [data {:lang  (tr [:page/lang])
              :loading (tr [:page/loading])
              :title (tr [:page/title])
              :content {:name {:title (tr [:author.name/title])
                               :value (tr [:author.name/value])}
                        :profession {:title (tr [:author.profession/title])
                                     :value (tr [:author.profession/value])}
                        :bio {:title (tr [:author.bio/title])
                              :value (tr [:author.bio/value])}}}
        body (rum/render-static-markup (page data))]

    (layout/render {:lang lang
                    :body body})))
