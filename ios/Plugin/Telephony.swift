import Foundation

@objc public class Telephony: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
