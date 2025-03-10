import "./PlansPricing.css";

function PlansPricing() {
  return (
    <div className="pricing-container">
      <h1>Plans & Pricing</h1>
      <div className="plans">
        <div className="plan">
          <h2>Basic</h2>
          <p>$19/month</p>
          <ul>
            <li>Access to 10 courses</li>
            <li>Community support</li>
          </ul>
        </div>
        <div className="plan">
          <h2>Pro</h2>
          <p>$49/month</p>
          <ul>
            <li>Unlimited courses</li>
            <li>Priority support</li>
            <li>Project reviews</li>
          </ul>
        </div>
      </div>
    </div>
  );
}

export default PlansPricing;
