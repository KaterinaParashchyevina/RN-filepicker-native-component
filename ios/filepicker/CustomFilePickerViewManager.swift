@objc (RCTCustomFilePickerViewManager)
class CustomFilePickerViewManager: RCTViewManager {

  override static func requiresMainQueueSetup() -> Bool {
    return true
  }

  override func view() -> UIView! {
    return CustomFilePickerView()
  }

}
