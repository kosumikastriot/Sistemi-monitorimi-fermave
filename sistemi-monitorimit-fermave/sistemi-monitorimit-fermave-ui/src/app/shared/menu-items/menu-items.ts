import {Injectable} from '@angular/core';

export interface BadgeItem {
  type: string;
  value: string;
}

export interface ChildrenItems {
  state: string;
  target?: boolean;
  name: string;
  type?: string;
  children?: ChildrenItems[];
}

export interface MainMenuItems {
  state: string;
  short_label?: string;
  main_state?: string;
  target?: boolean;
  name: string;
  type: string;
  icon: string;
  badge?: BadgeItem[];
  children?: ChildrenItems[];
}

export interface Menu {
  label: string;
  main: MainMenuItems[];
}

const MENUITEMS = [
  {
    label: 'Paneli',
    main: [
      {
        state: 'dashboard',
        short_label: 'S',
        name: 'Dashboard',
        type: 'link',
        icon: 'ti-dashboard'
      },
      {
        state: 'pajisjet',
        short_label: 'S',
        name: 'Pajsijet',
        type: 'link',
        icon: 'ti-panel'
      },
      {
        state: 'senzoret',
        short_label: 'S',
        name: 'Senzoret',
        type: 'link',
        icon: 'ti-signal'
      },
      {
        state: 'konfigurimet',
        short_label: 'S',
        name: 'Konfigurimet',
        type: 'link',
        icon: 'ti-file'
      },
      {
        state: 'simulimi',
        short_label: 'S',
        name: 'Simulimi',
        type: 'link',
        icon: 'ti-desktop'
      }
    ]
  }
];

@Injectable()
export class MenuItems {
  getAll(): Menu[] {
    return MENUITEMS;
  }
}
