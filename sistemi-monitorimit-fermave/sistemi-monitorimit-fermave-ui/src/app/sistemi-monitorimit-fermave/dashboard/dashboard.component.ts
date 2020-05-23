import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-simple-page',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss',
    '../../../assets/icon/icofont/css/icofont.scss']
})
export class DashboardComponent implements OnInit {
  powerCardData: any;
  powerCardOption: any;

  constructor() { }

  ngOnInit() {
    this.powerCardData = this.gurubuildchartjs('#4099ff', [10, 25, 35, 20, 10, 20, 15, 45, 15, 10], null);
    this.powerCardOption = this.gurubuildchartoption();
  }

  gurubuildchartjs(a, b, f) {
    if (f == null) {
    f = 'rgba(0,0,0,0)';
  }

  return {
  labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October'],
  datasets: [{
    label: '',
    borderColor: a,
    borderWidth: 2,
    hitRadius: 30,
    pointHoverRadius: 4,
    pointBorderWidth: 50,
    pointHoverBorderWidth: 12,
    pointBackgroundColor: 'transparent',
    pointBorderColor: 'transparent',
    pointHoverBackgroundColor: a,
    pointHoverBorderColor: 'transparent',
    fill: true,
    backgroundColor: f,
    data: b,
  }]
};
}
gurubuildchartoption() {
  return {
    title: {
      display: !1
    },
    tooltips: {
      enabled: true,
      intersect: !1,
      mode: 'nearest',
      xPadding: 10,
      yPadding: 10,
      caretPadding: 10
    },
    legend: {
      display: !1,
      labels: {
        usePointStyle: !1
      }
    },
    responsive: !0,
    maintainAspectRatio: !0,
    hover: {
      mode: 'index'
    },
    scales: {
      xAxes: [{
        display: !1,
        gridLines: !1,
        scaleLabel: {
          display: !0,
          labelString: 'Month'
        }
      }],
      yAxes: [{
        display: !1,
        gridLines: !1,
        scaleLabel: {
          display: !0,
          labelString: 'Value'
        },
        ticks: {
          beginAtZero: !0
        }
      }]
    },
    elements: {
      point: {
        radius: 4,
        borderWidth: 12
      }
    },
    layout: {
      padding: {
        left: 0,
        right: 0,
        top: 5,
        bottom: 0
      }
    }
  };
}

}
