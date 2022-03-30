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
        UITabBar.appearance().backgroundColor = UIColor.primaryColor
        UITabBar.appearance().unselectedItemTintColor =  UIColor.secondaryColor
    }
    var body: some View {
        
        TabView {
            CharactersView()
                .tabItem {
                    Image("character")
                        .renderingMode(.template)
                        .foregroundColor(.gray)
                        .opacity(0.4)
                    Text("Character")
                }
            
            LocationsView()
                .tabItem {
                    Image("locations")
                        .renderingMode(.template)
                        .foregroundColor(.gray)
                        .opacity(0.4)
                    Text("Location")
                }
            
            EpisodesView()
                .tabItem {
                    Image("episodes")
                        .renderingMode(.template)
                        .foregroundColor(.gray)
                        .opacity(0.4)
                    Text("Episodes")
                    
                }
        }//: TABVIEW
        
//        .onAppear(){
//            UITabBar.appearance().backgroundColor = UIColor.primaryColor
//        }
        
        .accentColor(.white)
        
    }

}

//
//
//    UITabBar.appearance().isOpaque = false
//}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
