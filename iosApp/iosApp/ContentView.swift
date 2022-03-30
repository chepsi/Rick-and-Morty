import SwiftUI
import shared

struct ContentView: View {
	let greet = "Just a try"

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
