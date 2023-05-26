//
//  CharactersView.swift
//  iosApp
//
//  Created by Evans Chepsiror on 28/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct CharactersView: View {
    var body: some View {
        
        ScrollView(showsIndicators: false) {
            VStack {
                HStack{
                    Image("character")
                        .renderingMode(.template)
                        .foregroundColor(ColorManager.primary)
                    Spacer()
                    Button(action: {
                        
                    }) {
                        ZStack {
                            Image("search")
                            Image(systemName: "magnifyingglass")
                                .foregroundColor(.white)
                        }
                    }
                }
                .padding()
                Spacer()
                
                ZStack {
                    Image("character_overlay")
                        .offset(y: 15)
                    
                    BannerTabview()
                        .frame(width: UIScreen.main.bounds.width - 50, height: 210)
                        .padding(.vertical, 20)
                }
                Spacer()
                Spacer()
                Spacer()
                Text("Character")
            }
        }
    }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        CharactersView()
    }
}
