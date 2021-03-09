import UIKit

class CustomFilePickerView: UIView {
    
    
    var filePickerButton: UIButton!
    @objc var onClick: RCTBubblingEventBlock?
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setupView()
    }
    
    private func setupView() {
        // in here you can configure your view
        filePickerButton = UIButton(type: .system)
        filePickerButton.setTitle("Choose file", for: .normal)
        filePickerButton.addTarget(self,action: Selector("onClick"), for: .touchesEnded)
        self.addSubview(filePickerButton)
    }
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard let onClick = self.onClick else { return }
        
        let params: [String : Any] = ["value1":"react demo","value2":1]
        onClick(params)
    }
    
}


