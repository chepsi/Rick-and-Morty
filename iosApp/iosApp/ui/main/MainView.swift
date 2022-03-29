//
//  MainView.swift
//  iosApp
//
//  Created by Evans Chepsiror on 28/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    
    
    init() {
          UITabBar.appearance().barTintColor = .white
      }
    var body: some View {

                TabView {
                 CharactersView()
                      .tabItem {
                          Image("character")
                              .renderingMode(.template)
                              .foregroundColor(.gray)
                      }
                  
                  LocationsView()
                      .tabItem {
                          Image("locations")
                              .renderingMode(.template)
                              .foregroundColor(.gray)
                      }
                  
                  EpisodesView()
                      .tabItem {
                          Image("episode")
                              .renderingMode(.template)
                              .foregroundColor(.gray)
                      
                      }
              }//: TABVIEW
              .accentColor(.black)
          }
      }
    


struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
